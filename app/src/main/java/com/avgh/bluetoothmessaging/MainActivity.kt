package com.avgh.bluetoothmessaging

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.avgh.bluetoothmessaging.server.ServerAdmin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.test).setOnClickListener {
            startActivity(Intent(this, ServerAdmin::class.java))
        }
    }
}
