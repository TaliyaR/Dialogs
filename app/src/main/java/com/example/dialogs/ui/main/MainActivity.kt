package com.example.dialogs.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.dialogs.R
import com.example.dialogs.ui.chat.DialogActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!DialogActivity.CHAT_FLAG) {
            btn_chat.isVisible = false
        } else {
            btn_chat.setOnClickListener { startActivity(DialogActivity.createIntent(this)) }
        }
    }
}