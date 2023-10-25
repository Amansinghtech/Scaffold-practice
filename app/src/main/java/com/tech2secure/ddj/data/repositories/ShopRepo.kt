package com.tech2secure.ddj.data.repositories

data class Product(
    val name: String,
    val price: Int,
    val SKU: String,
    val description: String,
    val image: String
)

interface ShopRepo {
    suspend fun getAllProducts(): List<Product>
}