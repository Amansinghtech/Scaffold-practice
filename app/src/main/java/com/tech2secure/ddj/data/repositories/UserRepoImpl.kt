package com.tech2secure.ddj.data.repositories

import com.tech2secure.ddj.data.models.User

class UserRepoImpl : UserRepo {
    override fun getUser(name: String, age: Int): User {
        return User(name, age)
    }
}