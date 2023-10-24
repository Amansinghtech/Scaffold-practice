package com.tech2secure.ddj.main.dashboard

import androidx.lifecycle.ViewModel
import com.tech2secure.ddj.data.models.User
import com.tech2secure.ddj.data.repositories.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val userRepo: UserRepo
) : ViewModel() {

    var myName = "Harsh"
    fun getUser(): User {
        return userRepo.getUser("Raj", 21)
    }
}