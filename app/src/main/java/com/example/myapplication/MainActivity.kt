package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.db.Book
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val dao = (application as App).db.getBookDao()
//        dao.insert(Book(0, "author", "name", 2020))
//        dao.selectAll().forEach {
//            Toast.makeText(this,it.toString(), Toast.LENGTH_SHORT)
//        }


//        GlobalScope.launch {
//            val dao = (application as App).db.getBookDao()
//            dao.insert(Book(0, "author", "name", 2020))
//       val list=dao.selectAll()
//            runOnUiThread {
//                Toast.makeText(applicationContext,list.toString(), Toast.LENGTH_SHORT)
//            }
//        }


        val dao = (application as App).db.getBookDao()
       val dis = dao.selectModern()
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(Schedulers.io())
            .subscribe( {
                Toast.makeText(applicationContext,it.toString(), Toast.LENGTH_SHORT)
            },{

        })


    }
}