package com.andrewtsaturov.datingtestapp.domain.repository.start

import com.andrewtsaturov.datingtestapp.data.cache.start.IStartScreenCache
import com.andrewtsaturov.datingtestapp.domain.etnity.Person
import io.reactivex.Observable
import io.reactivex.Single
import kotlin.random.Random

class StartScreenRepository(private val cache: IStartScreenCache):
    IStartScreenRepository {

    override fun observePerson(): Observable<List<Person>> = cache.observePerson()

    override fun updatePersonList(): Single<List<Person>> {
        val testPeoples = mutableListOf<Person>()
        testPeoples.add(Person(1, Person.MALE, "Никита", "file:///android_asset/m1.png"))
        testPeoples.add(Person(2, Person.MALE, "Александр", "file:///android_asset/m2.png"))
        testPeoples.add(Person(3, Person.MALE, "Андрей", "file:///android_asset/m3.png"))
        testPeoples.add(Person(4, Person.MALE, "Алексей", "file:///android_asset/m4.png"))
        testPeoples.add(Person(5, Person.MALE, "Дмитрий", "file:///android_asset/m5.png"))
        testPeoples.add(Person(6, Person.FEMALE, "Алена", "file:///android_asset/w1.png"))
        testPeoples.add(Person(7, Person.FEMALE, "Анастасия", "file:///android_asset/w2.png"))
        testPeoples.add(Person(8, Person.FEMALE, "Алиса", "file:///android_asset/w3.png"))
        testPeoples.add(Person(9, Person.FEMALE, "Екатерина", "file:///android_asset/w4.png"))

        testPeoples.shuffle()

        return cache.updatePersonList(testPeoples)
    }

    override fun updateOnlineCounter(): Single<Int> = cache.updateOnlineCounter(Random.nextInt(500, 1000))

    override fun observeOnlineCounter(): Observable<Int> = cache.observeOnlineCounter()
}