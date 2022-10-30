package com.example.homeproject3.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.homeproject3.adapter.UserAdapter
import com.example.homeproject3.databinding.ActivityMainBinding
import com.example.homeproject3.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        viewModel.loadUserData()

        val recyclerView: RecyclerView = binding.userList
        recyclerView.adapter = UserAdapter(viewModel.userLiveData.value!!)
    }
}