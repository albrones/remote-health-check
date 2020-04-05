package com.zenika.remotehealthcheck

import com.zenika.remotehealthcheck.Evolution.BETTER
import com.zenika.remotehealthcheck.State.MEDIUM
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
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
internal class ChoiceMutationTest(
        @Autowired val choiceRepository: ChoiceRepository,
        @Autowired val testRestTemplate: TestRestTemplate,
        @LocalServerPort val port: Int,
        @Value("classpath:requests/save-choice.json") val saveChoiceRequestResource: Resource,
        @Value("classpath:responses/save-choice.json") val saveChoiceResponseResource: Resource
) {

    @AfterEach
    fun `clean database`() {
        choiceRepository.deleteAll().block()
    }

    @Test
    internal fun `should save new choice`() {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val request = HttpEntity(saveChoiceRequestResource.readContentAndNormalize(), headers)
        val response = testRestTemplate.postForEntity("http://localhost:$port/graphql", request, String::class.java)
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        val choices = choiceRepository.findAll().collectList().block() ?: emptyList()
        assertThat(choices).hasSize(1)
        val choice = choices.toList()[0]
        assertThat(choice).extracting(Choice::questionId).isEqualTo(1L)
        assertThat(choice).extracting(Choice::state).isEqualTo(MEDIUM)
        assertThat(choice).extracting(Choice::evolution).isEqualTo(BETTER)
        assertThat(response.body).isEqualTo(saveChoiceResponseResource.readContentAndNormalize()
                .replace("{id}", choice.id ?: throw IllegalStateException("Invalid saved choice id")))

    }
}