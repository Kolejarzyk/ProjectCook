package com.example.kolejarz.cook

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.kolejarz.cook.DBTest.Companion.newProductsActivityRequestCode
import com.example.kolejarz.cookdb.Products

class DbTestActivityTest: AppCompatActivity() {

    private lateinit var editProductsView: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_product_test)
        editProductsView = findViewById(R.id.edit_products)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editProductsView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val products = editProductsView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, products)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.productslistsql.REPLY"
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newProductsActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.let {
                val products = Products(it.getStringExtra(NewProductsActivity.EXTRA_REPLY))
                productsViewModel.insert(products)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
        }

    }


}