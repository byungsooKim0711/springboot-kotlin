package org.kimbs.demo

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication {
    private val log = LoggerFactory.getLogger(DemoApplication::class.java);

}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
