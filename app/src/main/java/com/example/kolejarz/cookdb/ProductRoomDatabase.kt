package com.example.kolejarz.cookdb

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = arrayOf(Product::class), version = 1)
public abstract class ProductRoomDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDAO

    companion object {
        @Volatile
        private var INSTANCE: ProductRoomDatabase? = null

        fun getDatabase(context: Context,scope: CoroutineScope): ProductRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductRoomDatabase::class.java,
                    "Word_database"
                ).addCallback(ProductDatabaseCallback(scope)).build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class ProductDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.productDao())
                }
            }
        }

        fun populateDatabase(wordDao: ProductDAO) {
            wordDao.deleteAll()

            var product = Product(1,"Jabłko")
            wordDao.insert(product)
            product = Product(2,"Marchewka")
            wordDao.insert(product)
        }
    }

}




