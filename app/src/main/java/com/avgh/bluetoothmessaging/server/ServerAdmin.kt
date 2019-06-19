package com.avgh.bluetoothmessaging.server

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.ToggleButton
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import com.avgh.bluetoothmessaging.R

class ServerAdmin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server_admin)
        findViewById<ToggleButton>(R.id.activator).setOnCheckedChangeListener { buttonView, isChecked ->
            changeAnimation(buttonView, isChecked)
        }
    }

    private fun changeAnimation(button: CompoundButton, isOn: Boolean) {
        val color = if (isOn)
            Color.rgb(3, 205, 203)
        else Color.rgb(0, 0, 0)
        val newDraw = AppCompatResources.getDrawable(this, R.drawable.ic_hexagon)
        val wrappedDraw = newDraw?.let { DrawableCompat.wrap(it) }
        if (wrappedDraw != null) {
            DrawableCompat.setTint(wrappedDraw, color)
            button.background = wrappedDraw
        }

    }

}
