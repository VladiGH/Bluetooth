package com.avgh.bluetoothmessaging.server

import android.bluetooth.BluetoothAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ToggleButton
import com.avgh.bluetoothmessaging.R

class ServerAdmin : AppCompatActivity() {

    private val adapter = BluetoothAdapter.getDefaultAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server_admin)

        findViewById<ToggleButton>(R.id.activator)
            .setOnCheckedChangeListener { _, isChecked ->
                startServer(isChecked)
            }

    }

    private fun startServer(status: Boolean) {
        if (status) adapter.enable() else adapter.disable()
        val pairedDevices = adapter.bondedDevices
        pairedDevices.forEach {
            Log.d("ServerBlue", it.name)
        }
    }

}
