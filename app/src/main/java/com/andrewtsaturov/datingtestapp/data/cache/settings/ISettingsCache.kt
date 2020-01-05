package com.andrewtsaturov.datingtestapp.data.cache.settings

import com.andrewtsaturov.datingtestapp.domain.etnity.Settings
import io.reactivex.Observable
import io.reactivex.Single

interface ISettingsCache {
    fun observeSettings(): Observable<Settings>
    fun updateSettings(settings: Settings): Single<Settings>
}