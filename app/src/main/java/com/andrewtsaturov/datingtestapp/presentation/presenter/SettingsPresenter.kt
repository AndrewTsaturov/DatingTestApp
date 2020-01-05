package com.andrewtsaturov.datingtestapp.presentation.presenter

import com.andrewtsaturov.datingtestapp.domain.etnity.Settings
import com.andrewtsaturov.datingtestapp.domain.interactor.settings.ISettingsInteractor
import com.andrewtsaturov.datingtestapp.presentation.common.ISchedulers
import com.andrewtsaturov.datingtestapp.presentation.view.ISettingsView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.plusAssign
import ru.terrakok.cicerone.Router

@InjectViewState
class SettingsPresenter(
    private val router: Router,
    private val schedulesrs: ISchedulers,
    private val settingsInteractor: ISettingsInteractor
    ): MvpPresenter<ISettingsView>() {
    private val disposable = CompositeDisposable()
    lateinit var settings: Settings

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        settingsInteractor
            .observeSettings()
            .subscribeOn(schedulesrs.io())
            .observeOn(schedulesrs.ui())
            .subscribe({
                settings = it
                viewState.updateSettings(it)
            }, {
                it.printStackTrace()
            })
            .untilDestroy()
    }

    fun back() = router.exit()

    fun cameraPermissionChecked(isChecked: Boolean){
        if(isChecked)
            viewState.requestCameraPermission()
    }

    fun Disposable.untilDestroy() {
        disposable += this
    }

    fun cameraSettingsUpdate(checked: Boolean){
        settings.cameraPermission = checked
        updateSettings()
    }

    fun loockForMen(checked: Boolean){
        settings.lookForMen = checked
        updateSettings()
    }

    fun loockForWomen(checked: Boolean){
        settings.lookForWoman = checked
        updateSettings()
    }

    private fun updateSettings(){
        settingsInteractor.updateSettings(settings)
            .subscribeOn(schedulesrs.io())
            .observeOn(schedulesrs.ui())
            .subscribe({
            }, {
                it.printStackTrace()
            })
            .untilDestroy()
    }
}