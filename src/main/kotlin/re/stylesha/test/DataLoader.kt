package re.stylesha.test

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import re.stylesha.test.dto.Goods
import re.stylesha.test.repository.GoodRepository

@Component
class DataLoader : ApplicationRunner {
    @Autowired
    lateinit var goodRepository : GoodRepository

    override fun run(args: ApplicationArguments) {
        val objectMapper = ObjectMapper()
        var goodsList = objectMapper.readValue<Goods>(ClassPathResource("data.json").file)

        for(good in goodsList.goods) {
            var goodId = good.id
            good.options.forEach {
                it.goodId = goodId
            }
            goodRepository.save(good)
        }

    }
}