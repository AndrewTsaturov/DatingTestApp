package com.andrewtsaturov.datingtestapp.domain.interactor.settings

import com.andrewtsaturov.datingtestapp.domain.etnity.Settings
import io.reactivex.Observable
import io.reactivex.Single

interface ISettingsInteractor {
    fun observeSettings(): Observable<Settings>
    fun updateSettings(settings: Settings): Single<Settings>
}