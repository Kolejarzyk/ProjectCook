package com.example.kolejarz.cookdb

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import kotlin.coroutines.CoroutineContext

class ProductsViewModel(application: Application) : AndroidViewModel(application) {

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    private val repository: ProductsRepository
    val allProducts: LiveData<List<Products>>

    init {
        val productsDAO = ProductsRoomDatabase.getDatabase(application, scope).productsDAO()
        repository = ProductsRepository(productsDAO)
        allProducts = repository.allProducts
    }

    fun insert(products: Products) = scope.launch(Dispatchers.IO) {
        repository.insert(products)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}