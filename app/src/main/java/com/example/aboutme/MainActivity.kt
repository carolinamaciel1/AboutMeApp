package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    private val myName  = MyName("Carolina Maciel")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButtonId.setOnClickListener{addNickname(it)}
    }

    private fun addNickname(view: View){
        myName.nickname = nicknameEditView.text.toString()
        binding.nicknameTextView.text = binding.nicknameEditView.text
        binding.nicknameEditView.visibility = View.GONE
        binding.doneButtonId.visibility = View.GONE
        binding.nicknameTextView.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}