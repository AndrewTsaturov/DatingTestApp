package com.andrewtsaturov.datingtestapp.domain.etnity

class Person(
    val id: Long,
    val gender: Int,
    val name: String,
    val imageUrl: String
){
    companion object {
        const val MALE = 1
        const val FEMALE = 0
    }
}