package com.example.kolejarz.cook

import com.example.kolejarz.DAO.ProductDao
import com.example.kolejarz.model.Product
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.BeforeClass

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ProductDAOTest {
    var products = ProductDao()

    @Before
    fun Before()
    {
        val product1 = Product("papryka", "paprykaczerwona", "bardzo czerwona", 1000, "A4", "No")
        val product2 = Product("ogorek", "zielonyzwykly", "bardzo zieony", 1000, "A4", "No")
        products.insertProduct(product1)
        products.insertProduct(product2)
    }


    @Test
    fun productDaoInsertWorking() {
        val product = Product("papryka", "paprykaczerwona", "bardzo czerwona", 1000, "A4", "No")
        products.insertProduct(product)
        assertEquals("papryka", "papryka", products.getById(2).product_name)
    }

    @Test
    fun productDaoUpdateWorking() {
        val product = products.getById(0)
        product.product_name = "czekolada"
        products.updateProduct(product, 0)
        assertEquals("czekolada", "czekolada", products.getById(0).product_name)
    }

    @Test
    fun productDaoDeleteWorking() {
        products.deleteProduct(0)
        assertEquals("size 1", 1, products.getProducts().size)
        assertNotEquals("deleted 1st", 0, products.getById(0))
    }
}