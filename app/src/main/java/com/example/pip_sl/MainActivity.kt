package com.example.pip_sl

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.app.PictureInPictureParams
import android.os.Build
import android.util.Rational
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//        val pipBtn:Button = findViewById(R.id.pipButton)
//        pipBtn.setOnClickListener(){
//            enterPictureInPictureMode()
//        }
//
//        private fun enterPictureInPictureMode() {
//            if (BUILD.VERSION.SDK_INT >= BUILD.VERSION_CODES.O) {
//                val aspectRatio =
//            }
//        }
//
//    }
//}




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pipButton: Button = findViewById(R.id.pipButton)

        // Set an OnClickListener on the button to enter PIP mode when clicked
        pipButton.setOnClickListener {
            enterPictureInPictureModeIfSupported()
        }
    }

    private fun enterPictureInPictureModeIfSupported() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val aspectRatio = Rational(16, 9) // Example aspect ratio for the PIP window
            val pipBuilder = PictureInPictureParams.Builder()
            pipBuilder.setAspectRatio(aspectRatio)
            enterPictureInPictureMode(pipBuilder.build())
        }
    }

    // Handle exiting PIP mode
    override fun onPictureInPictureModeChanged(
        isInPictureInPictureMode: Boolean,
        newConfig: android.content.res.Configuration
    ) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
        // Handle changes when entering or exiting PIP mode
        if (isInPictureInPictureMode) {
            // Hide UI elements when in PIP mode
        } else {
            // Restore UI elements when exiting PIP mode
        }
    }
}

