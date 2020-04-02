package com.zenika.remotehealthcheck

import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class ChoiceQuery(val choiceRepository: ChoiceRepository) : Query {

    //TODO fix Flux et graphql
    fun choicesByQuestion(questionId: Long): Flux<Choice> = choiceRepository.findByQuestionId(questionId)

    //TODO fix Flux et graphql
    fun choices(): Flux<Choice> = choiceRepository.findAll()
}
