package com.github.monolabhituszi.portal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.monolabhituszi.portal.databinding.ActivityTaskBinding

class TaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_task)

        val data = intent.getBundleExtra("DATA")
        binding.titleText = data?.getString("title")
        binding.descriptionText = data?.getString("description")
        binding.remainingText = data?.getString("remaining")
    }
}
