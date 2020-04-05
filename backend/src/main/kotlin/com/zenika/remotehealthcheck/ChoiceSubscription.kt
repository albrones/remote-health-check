package com.zenika.remotehealthcheck

import com.expediagroup.graphql.spring.operations.Subscription
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class ChoiceSubscription(val choiceRepository: ChoiceRepository) : Subscription {

    fun choicesByQuestion(questionId: Long): Flux<Choice> = choiceRepository.findByQuestionId(questionId)

    fun choices(): Flux<Choice> = choiceRepository.findAll()
}
