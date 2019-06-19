package com.avgh.bluetoothmessaging.client

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.avgh.bluetoothmessaging.R
import com.google.android.material.snackbar.Snackbar

class ServerConectionActivity : AppCompatActivity() {



    var bTAdapter : BluetoothAdapter? = null
    lateinit var  devices : Set<BluetoothDevice>
    var R_ENABLE_BLUETOOTH = 1

    companion object{
        val EXTRA_ADDRESS : String = "D_address"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server_conection)

        bTAdapter = BluetoothAdapter.getDefaultAdapter()

        if(bTAdapter == null){
            Toast.makeText(this,  "Su dispositivo no cuenta con tecnologia Bluetooth", Toast.LENGTH_LONG).show()
        }
        else if(!bTAdapter!!)
    }
}
