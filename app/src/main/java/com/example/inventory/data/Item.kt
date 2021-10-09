package com.example.inventory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat

//Entity class
//аргумент tableName, чтобы указать элемент в качестве имени таблицы SQLite
@Entity(tableName = "item")
data class Item(
    @PrimaryKey(autoGenerate = true) //@PrimaryKey Чтобы идентифицировать id как первичный ключ //autoGenerate = true, чтобы Room генерировал идентификатор для каждой сущности. Это гарантирует, что идентификатор для каждого элемента уникален.
    val id: Int = 0,
    @ColumnInfo(name = "name") //@ColumnInfo то же самое что и tableName
    val itemName: String,
    @ColumnInfo(name = "price")
    val itemPrice: Double,
    @ColumnInfo(name = "quantity")
    val quantityInStock: Int
)

fun Item.getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(itemPrice)