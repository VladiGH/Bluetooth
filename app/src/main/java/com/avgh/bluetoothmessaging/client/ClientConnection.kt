package com.avgh.bluetoothmessaging.client

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.util.Log
import java.io.IOException
import java.util.*

class ClientConnection(device: BluetoothDevice) : Thread() {

    private val random_UUID: UUID = UUID.fromString("3ceee1db-d30d-41f8-8379-5acde949b6f9")
    lateinit var mBluetoothSocket: BluetoothSocket
    lateinit var mBluetoothDevice: BluetoothDevice

    init {
        this.mBluetoothDevice = device
        try {
            mBluetoothSocket = mBluetoothDevice.createRfcommSocketToServiceRecord(random_UUID)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun run() {
        try {
            mBluetoothSocket.connect()
            Log.i("BT", "Conexion como cliente exitosa!")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}