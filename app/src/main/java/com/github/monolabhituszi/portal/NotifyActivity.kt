package com.github.monolabhituszi.portal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.monolabhituszi.portal.databinding.ActivityNotifyBinding

class NotifyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotifyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notify)
    }
}
