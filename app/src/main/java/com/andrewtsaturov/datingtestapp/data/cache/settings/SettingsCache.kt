package com.andrewtsaturov.datingtestapp.data.cache.settings

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.andrewtsaturov.datingtestapp.domain.etnity.Settings
import com.google.gson.Gson
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.Single

class SettingsCache(private val context: Context): ISettingsCache {
    companion object {
        private const val PREFS_NAME = "settings"
        private const val SETTINGS_PREFS_KEY = "settings"
    }

    private val settingsRelay = BehaviorRelay.create<Settings>()

    init{
        settingsRelay.accept(getSettingsFromPrefs()?: Settings())
    }

    override fun observeSettings(): Observable<Settings> = settingsRelay.hide()

    override fun updateSettings(settings: Settings): Single<Settings> = Single.fromCallable {
        settingsRelay.accept(settings)
        settings
    }

    private fun writeSettingsToPrefs(settings: Settings){
        val prefs = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        prefs.edit()
            .putString(SETTINGS_PREFS_KEY, Gson().toJson(settings))
            .apply()
    }

    private fun getSettingsFromPrefs(): Settings? {
        var result: Settings? = null

        val buffer = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).getString(SETTINGS_PREFS_KEY, "")

        if(!buffer.isNullOrBlank())
            result = Gson().fromJson(buffer, Settings::class.java)

        return result
    }
}