package com.example.myapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.db.Book
import io.reactivex.Flowable

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(book: Book)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg books: Book)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(books: List<Book>)

    @Query("SELECT * FROM Book")
    fun selectAll():List<Book>

    @Query("SELECT * FROM Book WHERE year>2000 AND year<=2010 ORDER BY year ASC")// по возрастанию ASC, DESC по убіванию
    fun selectModern():Flowable<List<Book>>

    @Query("DELETE FROM Book")
    fun clearTable()
}