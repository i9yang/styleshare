package re.stylesha.test

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import re.stylesha.test.dto.Goods
import re.stylesha.test.repository.Repository

@Component
class DataLoader : ApplicationRunner {
    @Autowired
    lateinit var goodRepository : Repository

    override fun run(args: ApplicationArguments) {
        val objectMapper = ObjectMapper()

        ClassPathResource("data.json").inputStream.use {
            input ->
                var goodList = objectMapper.readValue<Goods>(input)

                for(good in goodList.goods) {
                    var goodId = good.id
                    good.options.forEach {
                        it.goodId = goodId
                    }
                    goodRepository.insertGood(good)
                }
        }

    }
}