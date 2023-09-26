package com.harshsingh.recordkeeper

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.harshsingh.recordkeeper.databinding.ActivityMainBinding
import com.harshsingh.recordkeeper.databinding.FragmentRunningBinding

class RunningFragment : Fragment() {

    private lateinit var binding: FragmentRunningBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRunningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListener()

    }
    private fun setupClickListener(){
        binding.container5km.setOnClickListener { launchRunningRecordsScreen("5KM") }
        binding.container10km.setOnClickListener { launchRunningRecordsScreen("10KM") }
        binding.containerHalfMarathon.setOnClickListener { launchRunningRecordsScreen("Half Marathon") }
        binding.containerMarathon.setOnClickListener { launchRunningRecordsScreen("Marathon") }
    }

    private fun launchRunningRecordsScreen(distance: String) {
        val intent = Intent(context, EditRunningRecordActivity::class.java)
        intent.putExtra("Distance", distance)
        startActivity(intent)
    }
}