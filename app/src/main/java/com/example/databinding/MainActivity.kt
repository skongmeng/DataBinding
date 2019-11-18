package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Eng","010-1234567")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName
        binding.buttonDone.setOnClickListener{
            showName()
        }

    }

    private fun showName(){
        binding.apply{
            myName?.name = editTextName.text.toString()
            this.invalidateAll()
        }
        binding.apply{
            myName?.contact = editTextContact.text.toString()
            this.invalidateAll()
        }

    }
}
