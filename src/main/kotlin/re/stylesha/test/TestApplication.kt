package re.stylesha.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import javax.annotation.PostConstruct
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json
import java.util.HashMap
import org.h2.value.DataType.readValue
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.InitializingBean
import org.springframework.context.annotation.Bean
import java.nio.file.Files
import java.nio.file.Files.readAllBytes
import java.nio.file.Path


@EnableWebMvc
@SpringBootApplication
class TestApplication

fun main(args: Array<String>) {
	runApplication<TestApplication>(*args)
}