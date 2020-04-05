package com.zenika.remotehealthcheck

import com.zenika.remotehealthcheck.Evolution.BETTER
import com.zenika.remotehealthcheck.State.MEDIUM
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class ChoiceMutationTest(
        @Autowired val choiceRepository: ChoiceRepository,
        @Autowired val choiceMutation: ChoiceMutation
) {

    @AfterEach
    fun `clean database`() {
        choiceRepository.deleteAll().block()
    }

    @Test
    internal fun `should save new choice`() {
        runBlocking { choiceMutation.saveChoice(1, MEDIUM.name, BETTER.name) }
        val choices = choiceRepository.findAll().collectList().block() ?: emptyList()
        assertThat(choices).hasSize(1)
        assertThat(choices.toList()[0]).extracting(Choice::questionId).isEqualTo(1L)
        assertThat(choices.toList()[0]).extracting(Choice::state).isEqualTo(MEDIUM)
        assertThat(choices.toList()[0]).extracting(Choice::evolution).isEqualTo(BETTER)

    }
}