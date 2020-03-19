package com.zenika.remotehealthcheck

import com.expediagroup.graphql.spring.operations.Query
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class RemoteHealthCheckApplication

fun main(args: Array<String>) {
    runApplication<RemoteHealthCheckApplication>(*args)
}

@Component
class MyAwesomeQuery : Query {
    fun myAwesomeQuery(): Widget {
        return Widget(1, "toto")
    }
}

data class Widget(val id: Int, val value: String)
