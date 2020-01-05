package com.andrewtsaturov.datingtestapp.presentation.screen.start_screen

import android.os.Bundle
import android.view.View
import com.andrewtsaturov.datingtestapp.R
import com.andrewtsaturov.datingtestapp.domain.etnity.Person
import com.andrewtsaturov.datingtestapp.presentation.common.BaseFragment
import com.andrewtsaturov.datingtestapp.presentation.common.convertDipToPixels
import com.andrewtsaturov.datingtestapp.presentation.presenter.StartScreenPresenter
import com.andrewtsaturov.datingtestapp.presentation.screen.start_screen.adapter.PersonAdapter
import com.andrewtsaturov.datingtestapp.presentation.view.IStartScreenView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_start.*
import org.koin.android.ext.android.get


class StartScreenFragment: BaseFragment(), IStartScreenView, OnPersonClickListener {
    override val layoutResource: Int = R.layout.fragment_start

    @InjectPresenter
    lateinit var presenter: StartScreenPresenter

    @ProvidePresenter
    fun providePresenter(): StartScreenPresenter = get()

    private val personAdapter = PersonAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        start_accounts_rv.apply {
            adapter = personAdapter
//            setPadding(context.convertDipToPixels(80), context.convertDipToPixels(68),
//                context.convertDipToPixels(80), context.convertDipToPixels(12))
        }

        start_rewind_img.setOnClickListener {presenter.rewindClicked(start_accounts_rv.currentItem)}
        start_message_img.setOnClickListener { presenter.conversationClicked(start_accounts_rv.currentItem) }
        start_button_main.setOnClickListener { presenter.conversationClicked() }
        start_button_settings.setOnClickListener { presenter.settingsClicked() }
    }


    override fun onStart() {
        super.onStart()

        presenter.updatePersonsData()
    }

    override fun onPersonClick(position: Int) {
        presenter.conversationClicked(position)
    }

    override fun showPersonsList(person: List<Person>) = personAdapter.updateData(person)

    override fun updateOnlineCounter(count: Int) {
        start_online_counter.text = getString(R.string.start_screen_online_counter_prefix) + " " + count.toString()
    }

    override fun rewindBackPresonList(currentPosition: Int) {

    }
}