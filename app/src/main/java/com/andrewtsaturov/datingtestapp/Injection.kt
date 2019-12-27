package com.andrewtsaturov.datingtestapp

import com.andrewtsaturov.datingtestapp.presentation.navigation.LocalCiceroneHolder
import org.koin.dsl.module

val app = module {
    single { LocalCiceroneHolder() }
}