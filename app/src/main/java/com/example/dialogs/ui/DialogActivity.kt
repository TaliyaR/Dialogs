package com.example.dialogs.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dialogs.R
import com.example.dialogs.entities.Message
import com.example.dialogs.presentation.DialogPresenter
import com.example.dialogs.presentation.DialogView
import com.example.dialogs.ui.rv.MessageListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_dialog.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

@AndroidEntryPoint
class DialogActivity : MvpAppCompatActivity(), DialogView {

    companion object {
        fun newInstance() = DialogActivity()
    }

    @Inject
    lateinit var diPresenter: DialogPresenter

    @InjectPresenter
    lateinit var presenter: DialogPresenter

    @ProvidePresenter
    fun providePresenter() = diPresenter

    private val messageListAdapter = MessageListAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        btn_chatbox_send.setOnClickListener {
            presenter.onSentMessageClick(et_chatbox.text.toString())
        }

        rv_message_list.layoutManager = LinearLayoutManager(this)
        rv_message_list.adapter = messageListAdapter

    }

    override fun setMessageList(list: List<Message>) {
        messageListAdapter.setList(list)
    }
}