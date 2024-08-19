package com.sunil.customalertdialog

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunil.customalert.PositiveAlertDialog

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PositiveAlertDialog(this).showDialog()
    }
}

