package com.example.kolejarz.cookdb

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ProductRepository
    private val scope = CoroutineScope(couroutineContext)
    val allProducts: LiveData<List<Product>>

    init {
        val productsDao = ProductRoomDatabase.getDatabase(application,scope).productDao()
        repository = ProductRepository(productsDao)
        allProducts = repository.allProduct
    }

    private var parentJob = Job()

    private val couroutineContext: CoroutineContext
    get() = parentJob + Dispatchers.Main



    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

    fun insert(product: Product) = scope.launch(Dispatchers.IO) {
        repository.insert(product)
    }


}