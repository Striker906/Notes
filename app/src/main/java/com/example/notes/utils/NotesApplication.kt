package com.example.notes.utils

  import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Singleton

@HiltAndroidApp
@Singleton
class NotesApplication:Application() {

    companion object{
        lateinit var appContext:NotesApplication
    }

    override fun onCreate() {
        super.onCreate()

    }
}