package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: com.example.aboutme.databinding.ActivityMainBinding
    private val myName = MyName("Name", "Nickname")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneBtn.setOnClickListener { addNickname(it) }
    }

    private fun addNickname(it: View?) {
        binding.apply {
            invalidateAll()
            if (edit.text.isEmpty()) {
                Toast.makeText(applicationContext, getString(R.string.empty_nickname), Toast.LENGTH_LONG).show()
            } else {
                myName?.nickname = edit.text.toString()
                nickname.visibility = View.VISIBLE
                edit.visibility = View.GONE
                doneBtn.visibility = View.GONE
            }

        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it?.windowToken, 0)
    }
}
