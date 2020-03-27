package com.zenika.remotehealthcheck

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ChoiceRepository : CrudRepository<Choice, Long> {

    @Query("select * from choice c where c.question_id = :questionId")
    fun findByQuestionId(@Param("questionId") id: Long): List<Choice>
}