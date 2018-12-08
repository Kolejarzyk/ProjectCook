package com.example.kolejarz.cookdb

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Data class that represents our items.
 */

@Entity(tableName = "products")
data class products(@PrimaryKey(autoGenerate = true) var id: Long?,
                    @ColumnInfo(name = "name") var name: String,
                    @ColumnInfo(name = "fullname") var fullname: String,
                    @ColumnInfo(name = "description") var description: String,
                    @ColumnInfo(name = "calories") var calories: Int,
                    @ColumnInfo(name = "nutrition") var nutrition: String,
                    @ColumnInfo(name = "allergic") var allergic: String

){
    constructor():this(null,"","","",0,"",
        "")
}