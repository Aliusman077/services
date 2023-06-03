package com.example.taskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.taskapp.databinding.ActivityMainBinding
import com.example.taskapp.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var isMotionServiceRunning:Boolean=false
    private var isPocketServiceRunning:Boolean=false
    private var isChargingServiceRunning:Boolean=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel= ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))[MainViewModel::class.java]

        binding.motionButton.setOnClickListener {

            isMotionServiceRunning = if (isMotionServiceRunning){
                viewModel.stopGestureService()
                binding.motionButton.text="M s stopped"
                false
            }else{
                viewModel.startGestureService()
                binding.motionButton.text="M s started"
                true
            }

        }

        binding.pocketRemovalButton.setOnClickListener {
            isPocketServiceRunning = if (isPocketServiceRunning){
                binding.pocketRemovalButton.text="P s stopped"
                viewModel.stopPocketService()
                false
            }else{
                viewModel.startPocketService()
                binding.pocketRemovalButton.text="P s started"

                true
            }
        }


        binding.chargerRemovalButton.setOnClickListener {
            isChargingServiceRunning = if (isChargingServiceRunning){
                binding.chargerRemovalButton.text="C s stopped"
                viewModel.stopChargerService()
                false
            }else{
                viewModel.startChargerService()
                binding.chargerRemovalButton.text="C s started"

                true
            }
        }



    }




}