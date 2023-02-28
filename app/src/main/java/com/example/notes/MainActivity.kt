package com.example.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.notes.databinding.ActivityMainBinding
import com.example.notes.screens.getStarted.GetStartedFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) init()


    }


    private fun init() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, GetStartedFragment())
            .commit()
    }


}