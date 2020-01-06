package com.andrewtsaturov.datingtestapp.domain.repository.settings

import com.andrewtsaturov.datingtestapp.data.cache.settings.ISettingsCache
import com.andrewtsaturov.datingtestapp.domain.etnity.Settings
import io.reactivex.Observable
import io.reactivex.Single

class SettingsRepository(private val settingsCache: ISettingsCache): ISettingsRepository {
    override fun observeSettings(): Observable<Settings> = settingsCache.observeSettings()

    override fun updateSettings(settings: Settings): Single<Settings> = settingsCache.updateSettings(settings)
}