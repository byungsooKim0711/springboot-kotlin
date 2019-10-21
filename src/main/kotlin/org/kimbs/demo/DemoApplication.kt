package org.kimbs.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DemoApplication {

    @Bean
    fun init(departmentRepository: DepartmentRepository) = CommandLineRunner {
        departmentRepository.save(Department(1, "Solution", "201"));
        departmentRepository.save(Department(2, "Process", "202"));
        departmentRepository.save(Department(3, "Engineering", "203"));
        departmentRepository.save(Department(4, "Personnel", "204"));
        departmentRepository.save(Department(5, "Marketing", "205"));
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
