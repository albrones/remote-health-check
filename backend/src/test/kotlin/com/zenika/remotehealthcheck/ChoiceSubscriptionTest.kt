package com.zenika.remotehealthcheck

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class ChoiceSubscriptionTest(
        @Autowired val choiceRepository: ChoiceRepository,
        @Autowired val choiceSubscription: ChoiceSubscription
) {

    private val choice1Question1 = Choice(questionId = 1, state = State.BAD, evolution = Evolution.BETTER)
    private val choice2Question1 = Choice(questionId = 1, state = State.MEDIUM, evolution = Evolution.SAME)
    private val choice1Question2 = Choice(questionId = 2, state = State.GOOD, evolution = Evolution.WORSE)

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
        Assertions.assertThat(choiceSubscription.choices().collectList().block()).hasSize(3)
    }

    @Test
    internal fun `should return all choices corresponding to one question`() {
        val questionId = 1L
        Assertions.assertThat(choiceSubscription.choicesByQuestion(questionId).collectList().block())
                .hasSize(2)
                .allMatch { it.questionId == questionId }
    }
}