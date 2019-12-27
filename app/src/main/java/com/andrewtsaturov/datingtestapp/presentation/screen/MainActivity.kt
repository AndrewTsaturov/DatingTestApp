package com.andrewtsaturov.datingtestapp.presentation.screen

import android.os.Bundle
import com.andrewtsaturov.datingtestapp.R
import com.andrewtsaturov.datingtestapp.presentation.common.OnBackPressed
import com.andrewtsaturov.datingtestapp.presentation.navigation.LocalCiceroneHolder
import com.arellomobile.mvp.MvpAppCompatActivity
import org.koin.android.ext.android.get
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MvpAppCompatActivity() {

    private val navigatorHolder = get<LocalCiceroneHolder>().navigationHolder
    private val navigator by lazy { SupportAppNavigator(this, R.id.fragment_container) }
    private val router = get<LocalCiceroneHolder>().router


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.popBackStack()
            //router.newRootScreen(Screens.ChatScreen())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(R.id.fragment_container) as? OnBackPressed)?.onBackPressed()
            ?: back()
    }

    fun back(){
        moveTaskToBack(true)
    }
}
