package com.avgh.bluetoothmessaging.server

import android.animation.Animator
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.ToggleButton
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.DrawableCompat
import com.avgh.bluetoothmessaging.R

class ServerAdmin : AppCompatActivity() {

    private val colorOff = Color.rgb(48, 48, 48)
    private val colorOn = Color.rgb(3, 205, 203)
    private val rotation =
        RotateAnimation(
            360f,
            0f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        ).apply {
            duration = 2500
            interpolator = LinearInterpolator()
            repeatCount = Animation.INFINITE
        }
    private val views = mutableListOf<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server_admin)
        val main = findViewById<ConstraintLayout>(R.id.mainFrame)
        for (x in 0 until main.childCount) {
            if (main.getChildAt(x) is ImageView) {
                views.add(main.getChildAt(x) as ImageView)
            }
        }
        findViewById<ToggleButton>(R.id.activator).setOnCheckedChangeListener { _, isChecked ->
            setAnimation(isChecked)
        }
    }

    private fun setAnimation(isChecked: Boolean) {
        val animatorIn = ValueAnimator().apply {
            duration = 1000
            setEvaluator(ArgbEvaluator())
            setIntValues(
                if (isChecked) colorOff else colorOn,
                if (!isChecked) colorOff else colorOn
            )
        }
        animatorIn.addUpdateListener {
            findViewById<ImageView>(R.id.hexagon).apply {
                val newDraw = AppCompatResources.getDrawable(this@ServerAdmin, R.drawable.ic_hexagon)
                val wrappedDraw = newDraw?.let { DrawableCompat.wrap(it) }
                if (newDraw != null) {
                    DrawableCompat.setTint(newDraw, it.animatedValue as Int)
                    this.background = wrappedDraw
                }
            }
            findViewById<ImageView>(R.id.circler).apply {
                if (isChecked) {
                    visibility = View.VISIBLE
                    alpha = 0f
                    animate().alpha(1f)
                    startAnimation(this@ServerAdmin.rotation)
                } else {
                    alpha = 1f
                    animate().alpha(0f)
                }
            }
        }
        animatorIn.start()
    }

}
