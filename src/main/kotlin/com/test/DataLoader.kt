package com.test

import com.opencsv.CSVReader
import com.test.dto.Program
import com.test.dto.Region
import com.test.repository.RegionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.io.InputStreamReader
import java.nio.charset.Charset

@Component
class DataLoader : ApplicationRunner {
    @Autowired
    lateinit var regionRepository : RegionRepository

    override fun run(args: ApplicationArguments) {
        var regionId = 0
        var programId = 0
        var previousRegionNm = ""

        CSVReader(InputStreamReader(ClassPathResource("data.csv").inputStream, Charset.forName("EUC-KR")))
            .forEachIndexed { index, el ->
                if(index == 0) return@forEachIndexed
                if(previousRegionNm != el[3]) regionId++

                var region = Region()
                var program = Program()

                region.id = "region${regionId}"
                region.regionNm = el[3]
                program

                regionRepository.save(region)
                previousRegionNm = el[3]
        }
    }


}