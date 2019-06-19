package com.avgh.bluetoothmessaging

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.avgh.bluetoothmessaging.server.ServerAdmin
import com.google.android.material.snackbar.Snackbar
import java.util.*
import android.bluetooth.BluetoothSocket
import android.bluetooth.BluetoothServerSocket
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private val random_UUID: UUID = UUID.fromString("3ceee1db-d30d-41f8-8379-5acde949b6f9")

    var mBluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.test).setOnClickListener {
            startActivity(Intent(this, ServerAdmin::class.java))
        }
        if (mBluetoothAdapter == null){
            Snackbar.make(findViewById<Button>(R.id.test),"Sorry, bro no soportas bluetooth", Snackbar.LENGTH_LONG).show()
        }
    }

    //TODO: ACA ESTA PARCIALMENTE EL SERVIDOR PARA BLUETOOTH
    private inner class AcceptThread : Thread() {

        private val mmServerSocket: BluetoothServerSocket?

        init {
            // Use a temporary object that is later assigned to mmServerSocket,
            // because mmServerSocket is final
            var tmp: BluetoothServerSocket? = null
            try {
                // MY_UUID is the app's UUID string, also used by the client code
                tmp = mBluetoothAdapter.listenUsingRfcommWithServiceRecord("Name", random_UUID)
            } catch (e: IOException) {
            }

            mmServerSocket = tmp
        }

        override fun run() {
            var socket: BluetoothSocket? = null
            // Keep listening until exception occurs or a socket is returned
            while (true) {
                try {
                    socket = mmServerSocket!!.accept()
                } catch (e: IOException) {
                    break
                }

                // If a connection was accepted
                if (socket != null) {
                    //todo:  Do work to manage the connection (in a separate thread) HACER LA FUNCION
                    manageConnectedSocket(socket)
                    mmServerSocket.close()
                    break
                }
            }
        }

        /** Will cancel the listening socket, and cause the thread to finish  */
        fun cancel() {
            try {
                mmServerSocket!!.close()
            } catch (e: IOException) {
            }

        }
    }
    fun manageConnectedSocket(socket: BluetoothSocket){
        
    }


}
