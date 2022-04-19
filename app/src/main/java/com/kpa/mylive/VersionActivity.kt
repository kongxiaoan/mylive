package com.kpa.mylive

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kpa.mylive.databinding.ActivityMainBinding
import com.kpa.mylive.databinding.ActivityVersiuonBinding

class VersionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVersiuonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVersiuonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sampleText.text = getFFmpegVersionInfo()
    }

    private external fun getFFmpegVersionInfo(): String

    companion object {
        fun startVersionActivity(context: Context) {
            context.startActivity(Intent(context, VersionActivity::class.java))
        }
    }
}