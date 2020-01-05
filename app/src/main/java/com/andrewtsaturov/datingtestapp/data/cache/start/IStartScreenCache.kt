package com.andrewtsaturov.datingtestapp.data.cache.start

import com.andrewtsaturov.datingtestapp.domain.etnity.Person
import io.reactivex.Observable
import io.reactivex.Single

interface IStartScreenCache {
    fun observePerson(): Observable<List<Person>>
    fun updatePersonList(list: List<Person>): Single<List<Person>>

    fun updateOnlineCounter(counter: Int): Single<Int>
    fun observeOnlineCounter(): Observable<Int>
}