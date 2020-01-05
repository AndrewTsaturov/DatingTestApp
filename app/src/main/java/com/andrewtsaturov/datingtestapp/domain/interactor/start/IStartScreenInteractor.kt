package com.andrewtsaturov.datingtestapp.domain.interactor.start

import com.andrewtsaturov.datingtestapp.domain.etnity.Person
import io.reactivex.Observable
import io.reactivex.Single

interface IStartScreenInteractor {
    fun observePerson(): Observable<List<Person>>
    fun updatePersonList(): Single<List<Person>>

    fun updateOnlineCounter(): Single<Int>
    fun observeOnlineCounter(): Observable<Int>
}