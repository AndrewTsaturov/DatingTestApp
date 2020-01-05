package com.andrewtsaturov.datingtestapp.presentation.view

import com.andrewtsaturov.datingtestapp.domain.etnity.Person
import com.arellomobile.mvp.MvpView

interface IStartScreenView: MvpView {
    fun showPersonsList(person: List<Person>)
    fun updateOnlineCounter(count: Int)
    fun rewindBackPresonList(currentPosition: Int)
}