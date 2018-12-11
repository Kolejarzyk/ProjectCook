package com.example.kolejarz.cookdb

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface UserDAO {

    @Query("SELECT * from user_table ORDER BY Nickname ASC")
    fun getAllUsers(): LiveData<List<User>>

    @Insert
    fun insert(user: User)

    @Query("DELETE FROM user_table")
    fun deleteAll()
}