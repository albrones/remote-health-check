package com.zenika.remotehealthcheck

import com.expediagroup.graphql.spring.operations.Mutation
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class ChoiceMutation(val choiceRepository: ChoiceRepository) : Mutation {

    //TODO fix Mono et graphql
    fun saveChoice(questionId: Long, state: String, evolution: String): Mono<Choice> =
            choiceRepository.save(
                    Choice(questionId = questionId,
                            state = State.valueOf(state),
                            evolution = Evolution.valueOf(evolution)
                    )
            )
}
