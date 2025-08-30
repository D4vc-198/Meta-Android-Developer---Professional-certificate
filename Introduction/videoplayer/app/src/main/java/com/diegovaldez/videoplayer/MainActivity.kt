package com.diegovaldez.videoplayer

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.diegovaldez.videoplayer.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inicializamos el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Encontrar la clase VideoView por su ID
        val videoView = findViewById<VideoView>(binding.testView.id)

        //Creamos el mediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        // Especificamos la ubicacion del archivo multimedia
        val uri: Uri = Uri.parse(
            "android.resource://" + packageName
                    + "/raw/testvideo"
        )


        // Configuramos MediaController y URI, luego iniciamos el videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}