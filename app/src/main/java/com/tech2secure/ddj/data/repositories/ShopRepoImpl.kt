package com.tech2secure.ddj.data.repositories

import kotlinx.coroutines.delay

class ShopRepoImpl : ShopRepo {
    override suspend fun getAllProducts(): List<Product> {
        delay(2000)
        return listOf(
            Product(
                "T-Shirt",
                100,
                "SKU-1",
                "XL Size T-Shirt",
                "https://picsum.photos/200/300"
            ),
            Product(
                "Shirt",
                200,
                "SKU-2",
                "XL Size Shirt",
                "https://picsum.photos/200/300"
            ),
            Product(
                "Pant",
                300,
                "SKU-3",
                "XL Size Pant",
                "https://picsum.photos/200/300"
            ),
            Product(
                "Jeans",
                400,
                "SKU-4",
                "XL Size Jeans",
                "https://picsum.photos/200/300"
            ),
            Product(
                "Shorts",
                500,
                "SKU-5",
                "XL Size Shorts",
                "https://picsum.photos/200/300"
            ),
        )
    }
}