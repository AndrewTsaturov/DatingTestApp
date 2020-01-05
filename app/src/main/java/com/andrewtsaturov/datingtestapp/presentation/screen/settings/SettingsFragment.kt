package com.andrewtsaturov.datingtestapp.presentation.screen.settings

import android.os.Bundle
import android.view.View
import com.andrewtsaturov.datingtestapp.R
import com.andrewtsaturov.datingtestapp.domain.etnity.Settings
import com.andrewtsaturov.datingtestapp.presentation.common.BaseFragment
import com.andrewtsaturov.datingtestapp.presentation.presenter.SettingsPresenter
import com.andrewtsaturov.datingtestapp.presentation.view.ISettingsView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_settings.*
import org.koin.android.ext.android.get

class SettingsFragment: BaseFragment(), ISettingsView {
    override val layoutResource: Int = R.layout.fragment_settings

    @InjectPresenter
    lateinit var presenter: SettingsPresenter

    @ProvidePresenter
    fun providePresenter(): SettingsPresenter = get()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun updateSettings(settings: Settings) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun requestCameraPermission() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}