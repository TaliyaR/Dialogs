package com.example.dialogs.ui

import android.os.Bundle
import com.example.dialogs.R
import com.example.dialogs.presentation.DialogView
import moxy.MvpAppCompatActivity

class DialogActivity : MvpAppCompatActivity(), DialogView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
    }
}