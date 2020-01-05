package com.andrewtsaturov.datingtestapp.presentation.view

import com.arellomobile.mvp.MvpView

interface IConversationView: MvpView {
    fun showLoading()
    fun showPerson()
    fun retriveCamerPermission()
    fun showUserCamer()
}