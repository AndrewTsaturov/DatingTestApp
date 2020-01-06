package com.andrewtsaturov.datingtestapp.domain.interactor.settings

import com.andrewtsaturov.datingtestapp.domain.etnity.Settings
import com.andrewtsaturov.datingtestapp.domain.repository.settings.ISettingsRepository
import io.reactivex.Observable
import io.reactivex.Single

class SettingsInteractor(private val repository: ISettingsRepository): ISettingsInteractor{
    override fun observeSettings(): Observable<Settings> = repository.observeSettings()

    override fun updateSettings(settings: Settings): Single<Settings> = repository.updateSettings(settings)
}