package com.zenika.remotehealthcheck

import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class ChoiceQuery(val choiceRepository: ChoiceRepository) : Query {

    fun choicesByQuestion(questionId: Long): List<Choice> = choiceRepository.findByQuestionId(questionId)

    fun choices(): List<Choice> = choiceRepository.findAll().toList()
}
