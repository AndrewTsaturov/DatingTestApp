package com.andrewtsaturov.datingtestapp.domain.repository.settings

import com.andrewtsaturov.datingtestapp.domain.etnity.Settings
import io.reactivex.Observable
import io.reactivex.Single

interface ISettingsRepository {
    fun observeSettings(): Observable<Settings>
    fun updateSettings(settings: Settings): Single<Settings>
}