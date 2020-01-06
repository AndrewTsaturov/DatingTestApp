package com.andrewtsaturov.datingtestapp.presentation.screen.settings

import android.Manifest
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
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.OnPermissionDenied
import permissions.dispatcher.RuntimePermissions

@RuntimePermissions
class SettingsFragment: BaseFragment(), ISettingsView {
    override val layoutResource: Int = R.layout.fragment_settings

    @InjectPresenter
    lateinit var presenter: SettingsPresenter

    @ProvidePresenter
    fun providePresenter(): SettingsPresenter = get()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settings_back_button.setOnClickListener { presenter.back() }
        settings_switch_camera.setOnCheckedChangeListener{buttonView, isChecked -> presenter.cameraPermissionChecked(isChecked)}
        settings_switch_men.setOnCheckedChangeListener{buttonView, isChecked -> presenter.loockForMen(isChecked)}
        settings_switch_women.setOnCheckedChangeListener{buttonView, isChecked -> presenter.loockForWomen(isChecked)}
    }

    override fun updateSettings(settings: Settings) {
        settings_switch_camera.isChecked = settings.cameraPermission
        settings_switch_men.isChecked = settings.lookForMen
        settings_switch_women.isChecked = settings.lookForWoman
    }

    override fun requestCameraPermission() {
        cameraSetUpWithPermissionCheck()
    }

    @NeedsPermission(Manifest.permission.CAMERA)
    fun cameraSetUp(){
        presenter.cameraSettingsUpdate(true)
    }

    @OnPermissionDenied
    fun cameraDismised(){
        presenter.cameraSettingsUpdate(false)
    }
}