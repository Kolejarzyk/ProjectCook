package com.example.kolejarz.cookdb

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Data class that represents our USERS.
 */

@Entity(tableName = "user_table")
class User(@PrimaryKey
              @ColumnInfo(name = "Id") val id : Int,
              @ColumnInfo(name = "Nickname") val nickname: String,
              @ColumnInfo(name = "Password") val password: String,
              @ColumnInfo(name = "Email") val email: String
)