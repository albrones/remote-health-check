package com.zenika.remotehealthcheck

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RemoteHealthCheckApplication

fun main(args: Array<String>) {
    runApplication<RemoteHealthCheckApplication>(*args)
}