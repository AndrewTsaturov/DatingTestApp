package com.andrewtsaturov.datingtestapp.domain.interactor.start

import com.andrewtsaturov.datingtestapp.domain.etnity.Person
import com.andrewtsaturov.datingtestapp.domain.repository.start.IStartScreenRepository
import io.reactivex.Observable
import io.reactivex.Single


class StartScreenInteractor(private val startScreenRepository: IStartScreenRepository):
    IStartScreenInteractor {
    override fun observePerson(): Observable<List<Person>> = startScreenRepository.observePerson()

    override fun updatePersonList(): Single<List<Person>> = startScreenRepository.updatePersonList()

    override fun updateOnlineCounter(): Single<Int> = startScreenRepository.updateOnlineCounter()

    override fun observeOnlineCounter(): Observable<Int> = startScreenRepository.observeOnlineCounter()
}