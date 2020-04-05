package com.zenika.remotehealthcheck

import com.expediagroup.graphql.spring.operations.Mutation
import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.stereotype.Component

@Component
class ChoiceMutation(val choiceRepository: ChoiceRepository) : Mutation {

    suspend fun saveChoice(questionId: Long, state: String, evolution: String): Choice =
            choiceRepository.save(
                    Choice(questionId = questionId,
                            state = State.valueOf(state),
                            evolution = Evolution.valueOf(evolution)
                    )
            ).awaitFirst()
}
