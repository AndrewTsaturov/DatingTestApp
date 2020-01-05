package com.andrewtsaturov.datingtestapp.presentation.presenter

import com.andrewtsaturov.datingtestapp.domain.interactor.conversation.IConversationInteractor
import com.andrewtsaturov.datingtestapp.presentation.common.ISchedulers
import com.andrewtsaturov.datingtestapp.presentation.view.IConversationView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import ru.terrakok.cicerone.Router

@InjectViewState
class ConversationPresenter(
    private val router: Router,
    private val schedulesrs: ISchedulers,
    private val conversationInteractor: IConversationInteractor
    ): MvpPresenter<IConversationView>() {
    private val disposable = CompositeDisposable()


}