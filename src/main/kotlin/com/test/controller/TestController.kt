package com.test.controller

import com.test.repository.RegionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @Autowired
    lateinit var regionRepository : RegionRepository

    @GetMapping("/")
    fun index() : String {

        regionRepository.findAll().forEach {
            println(it)
        }

        return "hi"
    }

}