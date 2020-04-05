package com.zenika.remotehealthcheck

import com.zenika.remotehealthcheck.Evolution.*
import com.zenika.remotehealthcheck.State.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.core.io.Resource
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class ChoiceQueryTest(
        @Autowired val choiceRepository: ChoiceRepository,
        @Autowired val testRestTemplate: TestRestTemplate,
        @LocalServerPort val port: Int,
        @Value("classpath:requests/all-choices.json") val allChoicesRequestResource: Resource,
        @Value("classpath:responses/all-choices.json") val allChoicesResponseResource: Resource,
        @Value("classpath:requests/choices-by-question.json") val choicesByQuestionRequestResource: Resource,
        @Value("classpath:responses/choices-by-question.json") val choicesByQuestionResponseResource: Resource
) {

    private val choice1Question1 = Choice("6n6xItWt44wjeEM2p75O", questionId = 1, state = BAD, evolution = BETTER)
    private val choice2Question1 = Choice("PBASjsCwBmLRibQBGQel", questionId = 1, state = MEDIUM, evolution = SAME)
    private val choice1Question2 = Choice("Tr4C1OZROB6VmMd5buXt", questionId = 2, state = GOOD, evolution = WORSE)

    @BeforeEach
    internal fun `insert test data`() {
        choiceRepository.saveAll(listOf(choice1Question1, choice1Question2, choice2Question1)).blockLast()
    }

    @AfterEach
    internal fun `clean database`() {
        choiceRepository.deleteAll().block()
    }

    @Test
    internal fun `should return all choices`() {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val request = HttpEntity(allChoicesRequestResource.readContentAndNormalize(), headers)
        val response = testRestTemplate.postForEntity("http://localhost:$port/graphql", request, String::class.java)
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).isEqualTo(allChoicesResponseResource.readContentAndNormalize())
    }

    @Test
    internal fun `should return all choices corresponding to one question`() {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val request = HttpEntity(choicesByQuestionRequestResource.readContentAndNormalize(), headers)
        val response = testRestTemplate.postForEntity("http://localhost:$port/graphql", request, String::class.java)
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).isEqualTo(choicesByQuestionResponseResource.readContentAndNormalize())
    }
}

fun Resource.readContentAndNormalize() = this.file.readText()
        .replace("\\n".toRegex(), "")
        .replace("\\r\\n".toRegex(), "")
        .replace("\\s".toRegex(), "")