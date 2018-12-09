package com.example.kolejarz.cookdb

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import kotlin.coroutines.CoroutineContext

@Database(entities = [Products::class], version = 1)
public abstract class ProductsRoomDatabase : RoomDatabase() {
    abstract fun ProductsDAO(): ProductsDAO

    companion object {
        @Volatile
        private var INSTANCE: ProductsRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ProductsRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductsRoomDatabase::class.java,
                    "Products_database"
                ).addCallback(ProductsDatabaseCallback(scope)).build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class ProductsDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.productsDAO())
                }
            }
        }
    }

    fun populateDatabase(productsDAO: ProductsDAO) {
        productsDAO.deleteAll()

        var products = Products("Orange")
        productsDAO.insert(products)
        products = Products("Fruit!")
        productsDAO.insert(products)
    }
}

