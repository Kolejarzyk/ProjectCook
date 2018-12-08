package com.example.kolejarz.cookdb

import android.os.AsyncTask
import android.arch.lifecycle.LiveData
import android.app.Application


class productsRepository internal constructor(application: Application) {

    private val mProductsDao: productsDAO
    internal val allProducts: LiveData<List<products>>

    init {
        val db = productsDB.getDatabase(application)
        mProductsDao = db.productsDAO()
        allProducts = mProductsDao.getAllproducts()
    }


    fun insert(word: products) {
        insertAsyncTask(mProductsDao).execute(word)
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: productsDAO) :
        AsyncTask<products, Void, Void>() {

        override fun doInBackground(vararg params: products): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }
}