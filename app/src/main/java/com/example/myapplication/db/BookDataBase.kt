package com.example.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BookDataBase : RoomDatabase() {
    abstract fun getBookDao(): BookDao

    companion object {
        fun getInstance(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            BookDataBase::class.java,
            "books"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }


}