package com.example.myapplication

import android.app.Application
import com.example.myapplication.db.BookDataBase

class App :Application(){
    lateinit var db: BookDataBase
    override fun onCreate() {
        super.onCreate()
        db= BookDataBase.getInstance(this)
    }
}