package com.example.homeproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.homeproject.databinding.ActivityMainBinding
import com.example.homeproject.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnChange.setOnClickListener{updateText()}
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.str.observe(this, Observer {
            binding.txtChange.text = it.toString()
        })
    }

    private fun updateText(){
        viewModel.changeText()
    }
}