package com.andrewtsaturov.datingtestapp.presentation.view


import com.andrewtsaturov.datingtestapp.domain.etnity.Settings
import com.arellomobile.mvp.MvpView

interface ISettingsView: MvpView {
    fun updateSettings(settings: Settings)
    fun requestCameraPermission()
}