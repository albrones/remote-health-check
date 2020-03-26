package com.zenika.remotehealthcheck

import org.springframework.data.annotation.Id

data class Choice(@Id val id: Long?, val questionId: Long, val state: State, val evolution: Evolution)

enum class Evolution {
    WORSE, SAME, BETTER
}

enum class State {

    BAD, MEDIUM, GOOD

}
