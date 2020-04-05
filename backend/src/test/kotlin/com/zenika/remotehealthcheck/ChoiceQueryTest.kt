package com.zenika.remotehealthcheck

import com.zenika.remotehealthcheck.Evolution.*
import com.zenika.remotehealthcheck.State.*
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class ChoiceQueryTest(
        @Autowired val choiceRepository: ChoiceRepository,
        @Autowired val choiceQuery: ChoiceQuery
) {

    private val choice1Question1 = Choice(questionId = 1, state = BAD, evolution = BETTER)
    private val choice2Question1 = Choice(questionId = 1, state = MEDIUM, evolution = SAME)
    private val choice1Question2 = Choice(questionId = 2, state = GOOD, evolution = WORSE)

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
        assertThat(runBlocking { choiceQuery.choices() }).hasSize(3)
    }

    @Test
    internal fun `should return all choices corresponding to one question`() {
        val questionId = 1L
        assertThat(runBlocking { choiceQuery.choicesByQuestion(questionId) })
                .hasSize(2)
                .allMatch { it.questionId == questionId }
    }
}