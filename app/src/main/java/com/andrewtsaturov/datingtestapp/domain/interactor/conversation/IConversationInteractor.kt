package com.andrewtsaturov.datingtestapp.domain.interactor.conversation

import com.andrewtsaturov.datingtestapp.domain.etnity.Person
import io.reactivex.Observable
import io.reactivex.Single


interface IConversationInteractor {
    fun observePerson(): Observable<Person>
    fun getPersonById(id: Long): Single<Person>
    fun getRandomPerson(): Single<Person>
}