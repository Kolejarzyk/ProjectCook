package com.example.kolejarz.cookdb

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(products::class), version = 1)
abstract class productsDB : RoomDatabase() {

    abstract fun productsDAO(): productsDAO

    companion object {
        private var INSTANCE: productsDB? = null

        fun getInstance(context: Context): productsDB? {
            if (INSTANCE == null) {
                synchronized(productsDB::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        productsDB::class.java, "products.db")
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}