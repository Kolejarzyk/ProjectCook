package com.example.kolejarz.cookdb

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Products::class], version = 1)
public abstract class ProductsRoomDatabase : RoomDatabase() {
    abstract fun ProductsDAO(): ProductsDAO

    companion object {
        @Volatile
        private var INSTANCE: ProductsRoomDatabase? = null

        fun getDatabase(context: Context): ProductsRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductsRoomDatabase::class.java,
                    "Products_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}