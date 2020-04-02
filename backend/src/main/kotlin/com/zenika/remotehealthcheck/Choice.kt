package com.zenika.remotehealthcheck

import com.google.cloud.firestore.annotation.DocumentId
import org.apache.commons.lang3.RandomStringUtils
import org.springframework.cloud.gcp.data.firestore.Document

@Document(collectionName = "choices")
data class Choice(@DocumentId val id: String? = RandomStringUtils.randomAlphanumeric(20), val questionId: Long, val state: State, val evolution: Evolution)

enum class Evolution {
    WORSE, SAME, BETTER
}

enum class State {

    BAD, MEDIUM, GOOD

}
