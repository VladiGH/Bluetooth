package com.avgh.bluetoothmessaging.server

import android.bluetooth.BluetoothAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ToggleButton
import android.content.Intent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import android.bluetooth.BluetoothSocket
import android.util.Log
import java.io.IOException
import com.avgh.bluetoothmessaging.R


class ServerAdmin : AppCompatActivity() {

    private val adapter = BluetoothAdapter.getDefaultAdapter()
    private val requestBt = 8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server_admin)
        findViewById<ToggleButton>(R.id.activator)
            .setOnCheckedChangeListener { _, isChecked ->
                startServer(isChecked)
            }
    }

    private fun startServer(status: Boolean) {
        if (status) {
            if (!adapter.isEnabled) {
                val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(enableBtIntent, requestBt)
            }
            GlobalScope.launch {
                val connexion = adapter
                    .listenUsingRfcommWithServiceRecord(
                        "pancho",
                        UUID.fromString("3ceee1db-d30d-41f8-8379-5acde949b6f9")
                    )
                var socket: BluetoothSocket? = null
                while (true) {
                    try {
                        socket = connexion.accept()
                    } catch (e: IOException) {
                        Log.d("Pancho", "error capaz", e)
                        break
                    }
                    if (socket != null) {
                        val xd = socket.inputStream.readBytes().toString()
                        Log.d("Pancho", "mensaje xd: $xd")
                        break
                    }
                }
            }
        }
    }

}
