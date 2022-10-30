package com.example.homeproject3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homeproject3.model.User
import com.example.homeproject3.model.UserData

class UserViewModel : ViewModel() {
    private val userData: UserData = UserData()
    private val _userLiveData = MutableLiveData<List<User>>()
    val userLiveData : LiveData<List<User>> = _userLiveData

    fun loadUserData(){
        _userLiveData.value = userData.userList
    }
}