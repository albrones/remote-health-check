package com.zenika.remotehealthcheck

import com.expediagroup.graphql.spring.operations.Query
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import org.springframework.stereotype.Component

@Component
class ChoiceQuery(val choiceRepository: ChoiceRepository) : Query {

    suspend fun choicesByQuestion(questionId: Long): List<Choice> = choiceRepository.findByQuestionId(questionId).asFlow().toList()

    suspend fun choices(): List<Choice> = choiceRepository.findAll().asFlow().toList()
}
