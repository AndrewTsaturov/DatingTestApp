package com.andrewtsaturov.datingtestapp

import com.andrewtsaturov.datingtestapp.data.cache.settings.ISettingsCache
import com.andrewtsaturov.datingtestapp.data.cache.settings.SettingsCache
import com.andrewtsaturov.datingtestapp.data.cache.start.IStartScreenCache
import com.andrewtsaturov.datingtestapp.data.cache.start.StartScreenCache
import com.andrewtsaturov.datingtestapp.domain.interactor.settings.ISettingsInteractor
import com.andrewtsaturov.datingtestapp.domain.interactor.settings.SettingsInteractor
import com.andrewtsaturov.datingtestapp.domain.interactor.start.IStartScreenInteractor
import com.andrewtsaturov.datingtestapp.domain.interactor.start.StartScreenInteractor
import com.andrewtsaturov.datingtestapp.domain.repository.settings.ISettingsRepository
import com.andrewtsaturov.datingtestapp.domain.repository.settings.SettingsRepository
import com.andrewtsaturov.datingtestapp.domain.repository.start.IStartScreenRepository
import com.andrewtsaturov.datingtestapp.domain.repository.start.StartScreenRepository
import com.andrewtsaturov.datingtestapp.presentation.common.ISchedulers
import com.andrewtsaturov.datingtestapp.presentation.common.Schedulers
import com.andrewtsaturov.datingtestapp.presentation.navigation.LocalCiceroneHolder
import com.andrewtsaturov.datingtestapp.presentation.presenter.SettingsPresenter
import com.andrewtsaturov.datingtestapp.presentation.presenter.StartScreenPresenter
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val app = module {
    single { LocalCiceroneHolder() }

    single {Schedulers() as ISchedulers}

    single { StartScreenCache() as IStartScreenCache }
    single { StartScreenRepository(get()) as IStartScreenRepository }
    single { StartScreenInteractor(get()) as IStartScreenInteractor}

    single { SettingsCache(androidApplication()) as ISettingsCache}
    single { SettingsRepository(get()) as ISettingsRepository}
    single { SettingsInteractor(get()) as ISettingsInteractor}

    factory { StartScreenPresenter(get<LocalCiceroneHolder>().router, get(), get()) }
    factory { SettingsPresenter(get<LocalCiceroneHolder>().router, get(), get()) }
}