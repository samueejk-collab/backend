package com.example.testing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.persistence.autoconfigure.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["com.example.testing", "etec.bdd"])
@EntityScan("etec.bdd.entity")
@EnableJpaRepositories("etec.bdd.repository")
class SpringBootTestingApplication

fun main(args: Array<String>) {
	runApplication<SpringBootTestingApplication>(*args)
}