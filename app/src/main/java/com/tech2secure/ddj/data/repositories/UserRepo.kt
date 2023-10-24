package com.tech2secure.ddj.data.repositories

import com.tech2secure.ddj.data.models.User


interface UserRepo {
    fun getUser(name: String, age: Int): User
}