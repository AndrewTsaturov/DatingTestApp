package com.andrewtsaturov.datingtestapp.presentation.navigation

import androidx.fragment.app.Fragment
import com.andrewtsaturov.datingtestapp.presentation.screen.settings.SettingsFragment
import com.andrewtsaturov.datingtestapp.presentation.screen.start_screen.StartScreenFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    class Start(): SupportAppScreen(){
        override fun getFragment() = StartScreenFragment()
    }

    class Conversation(private val id: Int = 0): SupportAppScreen(){

    }

    class Settings(): SupportAppScreen(){
        override fun getFragment(): Fragment = SettingsFragment()
    }
}