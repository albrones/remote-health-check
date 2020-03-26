package com.zenika.remotehealthcheck

import com.zenika.remotehealthcheck.Evolution.*
import com.zenika.remotehealthcheck.State.*
import org.assertj.core.api.Assertions
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

    private val choice1Question1 = Choice(null, 1, BAD, BETTER)
    private val choice2Question1 = Choice(null, 1, MEDIUM, SAME)
    private val choice1Question2 = Choice(null, 2, GOOD, WORSE)

    @BeforeEach
    internal fun `insert test data`() {
        choiceRepository.saveAll(listOf(choice1Question1, choice1Question2, choice2Question1))
    }

    @AfterEach
    internal fun `clean database`() = choiceRepository.deleteAll()

    @Test
    internal fun `should return all choices`() {
        Assertions.assertThat(choiceQuery.choices()).hasSize(3)
    }

    @Test
    internal fun `should return all choices corresponding to one question`() {
        val questionId = 1L
        Assertions.assertThat(choiceQuery.choicesByQuestion(questionId))
                .hasSize(2)
                .allMatch { it.questionId == questionId }
    }
}