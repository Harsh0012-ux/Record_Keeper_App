package com.harshsingh.recordkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harshsingh.recordkeeper.databinding.ActivityEditCyclingRecordBinding
import com.harshsingh.recordkeeper.databinding.FragmentCyclingBinding

class EditCyclingRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditCyclingRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditCyclingRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val distance = intent.getStringExtra("Distance")
        title = "$distance Record"
    }
}