package com.harshsingh.recordkeeper

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.harshsingh.recordkeeper.databinding.ActivityEditRunningRecordBinding
import com.harshsingh.recordkeeper.databinding.FragmentCyclingBinding

class CyclingFragment : Fragment() {

    private lateinit var binding: FragmentCyclingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCyclingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListener()

    }

    private fun setupClickListener(){
        binding.containerAverageSpeed.setOnClickListener { launchCyclingRecordsScreen("Longest Ride") }
        binding.containerBiggestClimb.setOnClickListener { launchCyclingRecordsScreen("Biggest Climb") }
        binding.containerLongestRide.setOnClickListener { launchCyclingRecordsScreen("Average Speed") }
        binding.containerTopSpeed.setOnClickListener { launchCyclingRecordsScreen("Top Speed") }
    }

    private fun launchCyclingRecordsScreen(distance: String){
        val intent = Intent(context, EditCyclingRecordActivity::class.java)
        intent.putExtra("Distance", distance)
        startActivity(intent)
    }

}