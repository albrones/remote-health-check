package com.zenika.remotehealthcheck

import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface ChoiceRepository : FirestoreReactiveRepository<Choice> {

    fun findByQuestionId(@Param("questionId") id: Long): Flux<Choice>
}