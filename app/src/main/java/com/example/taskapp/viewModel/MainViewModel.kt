package com.example.taskapp.viewModel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.taskapp.service.ChargingService
import com.example.taskapp.service.MotionDetectionService
import com.example.taskapp.service.PocketRemovalService

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val context: Context = application


    fun startGestureService() {
        val intent = Intent(context, MotionDetectionService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ContextCompat.startForegroundService(context, intent)
        } else {
            context.startService(intent)
        }
    }


    fun stopGestureService() {
        val intent = Intent(context, MotionDetectionService::class.java)
        context.stopService(intent)
    }


    fun startPocketService() {
        val intent = Intent(context, PocketRemovalService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ContextCompat.startForegroundService(context, intent)
        } else {
            context.startService(intent)
        }
    }

    fun stopPocketService() {
        val intent = Intent(context, PocketRemovalService::class.java)
        context.stopService(intent)
    }


    fun startChargerService() {
        val intent = Intent(context, ChargingService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ContextCompat.startForegroundService(context, intent)
        } else {
            context.startService(intent)
        }
    }


    fun stopChargerService() {
        val intent = Intent(context, ChargingService::class.java)
        context.stopService(intent)
    }
}