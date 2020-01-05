package com.andrewtsaturov.datingtestapp.data.cache.start

import com.andrewtsaturov.datingtestapp.domain.etnity.Person
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.Single

class StartScreenCache: IStartScreenCache {
    private val personsRelay = BehaviorRelay.create<List<Person>>()
    private val counterRelay = BehaviorRelay.create<Int>()


    override fun observePerson(): Observable<List<Person>> = personsRelay.hide()

    override fun updatePersonList(list: List<Person>): Single<List<Person>> = Single.fromCallable {
        personsRelay.accept(list)
        list
    }

    override fun updateOnlineCounter(counter: Int): Single<Int> = Single.fromCallable {
        counterRelay.accept(counter)
        counter
    }

    override fun observeOnlineCounter(): Observable<Int> = counterRelay.hide()
}