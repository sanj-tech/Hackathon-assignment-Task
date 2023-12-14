package com.example.digitalflakedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.digitalflakedemo.databinding.ActivityMainBinding
import com.example.digitalflakedemo.fragments.HomeFragment
import com.example.digitalflakedemo.fragments.LoginFragment
import com.example.digitalflakedemo.fragments.SignUpFragment


class MainActivity : AppCompatActivity() {

    lateinit var signUpBinding: ActivityMainBinding

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.container)
        when (currentFragment) {
            is LoginFragment -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, LoginFragment())
                transaction.commit()
            }
            is SignUpFragment -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, SignUpFragment())
                transaction.commit()
            }
            is LoginFragment -> {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, HomeFragment())
                transaction.commit()
            }
            else -> super.onBackPressed()
        }
    }
//    override fun onBackPressed() {
//        val fragment = supportFragmentManager.findFragmentById(R.id.container)
//        if (fragment is SignUpFragment) {
//            val transaction = supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.container, SignUpFragment())
//            transaction.addToBackStack(null)
//            transaction.commit()
//        } else {
//            super.onBackPressed()
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        loadFragment(SignUpFragment())

    }


    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}

