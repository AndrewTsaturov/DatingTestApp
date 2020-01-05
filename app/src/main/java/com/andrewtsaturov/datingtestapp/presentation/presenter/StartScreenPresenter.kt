package com.andrewtsaturov.datingtestapp.presentation.presenter

import com.andrewtsaturov.datingtestapp.domain.interactor.start.IStartScreenInteractor
import com.andrewtsaturov.datingtestapp.presentation.common.ISchedulers
import com.andrewtsaturov.datingtestapp.presentation.navigation.Screens
import com.andrewtsaturov.datingtestapp.presentation.view.IStartScreenView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.plusAssign
import ru.terrakok.cicerone.Router

@InjectViewState
class StartScreenPresenter(
    private val router: Router,
    private val schedulesrs: ISchedulers,
    private val interactor: IStartScreenInteractor
): MvpPresenter<IStartScreenView>() {
    private val disposable = CompositeDisposable()



    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        interactor.observeOnlineCounter()
            .subscribeOn(schedulesrs.io())
            .observeOn(schedulesrs.ui())
            .subscribe({
                viewState.updateOnlineCounter(it)
            },{
                it.printStackTrace()
            })
            .untilDestroy()

        interactor.observePerson()
            .subscribeOn(schedulesrs.io())
            .observeOn(schedulesrs.ui())
            .subscribe({
                viewState.showPersonsList(it)
            },{
                it.printStackTrace()
            })
            .untilDestroy()
    }

    fun updatePersonsData() {
        interactor.updateOnlineCounter()
            .subscribeOn(schedulesrs.io())
            .observeOn(schedulesrs.ui())
            .doFinally { updatePersons() }
            .subscribe({

            },{
                it.printStackTrace()
            })
            .untilDestroy()
    }

    fun rewindClicked(currentItem: Int) {
        viewState.rewindBackPresonList(currentItem)
    }

    fun conversationClicked(currentItem: Int) {
        router.navigateTo(Screens.Conversation(currentItem))
    }

    fun conversationClicked() {
        router.navigateTo(Screens.Conversation())
    }

    fun settingsClicked() {
        router.navigateTo(Screens.Settings())
    }

    fun Disposable.untilDestroy() {
        disposable += this
    }

    private fun updatePersons(){
        interactor.updatePersonList()
            .subscribeOn(schedulesrs.io())
            .observeOn(schedulesrs.ui())
            .subscribe({

            },{
                it.printStackTrace()
            })
            .untilDestroy()
    }
}