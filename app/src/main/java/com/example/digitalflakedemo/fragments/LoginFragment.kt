package com.example.digitalflakedemo.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.digitalflakedemo.R
import com.example.digitalflakedemo.databinding.FragmentLoginBinding
import com.example.digitalflakedemo.retrofit.RetrofitClient
import com.example.digitalflakedemo.retrofitmodels.RetrofitLoginResponse
import com.example.digitalflakedemo.retrofitmodels.urlencoded
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {
    private lateinit var loginBinding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBinding =
            FragmentLoginBinding.inflate(LayoutInflater.from(context))
        val view: View = loginBinding.root
        return view
        // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeScreen()
        createAccountNewUser()
    }

    private fun createAccountNewUser() {
        loginBinding.tvCreateAccount.setOnClickListener({
            loginBinding.ll.visibility = View.INVISIBLE
            loadFragment(SignUpFragment())
        })
    }


    private fun homeScreen() {
        loginBinding.btnLogin.setOnClickListener({
            loginBinding.ll.visibility = View.VISIBLE
            val email = loginBinding.edtEmail.text.toString().trim()
            val password = loginBinding.edtPassword.text.toString().trim()
            if (email.isEmpty()) {
                loginBinding.edtEmail.error = "email required"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                loginBinding.edtPassword.error = "Password required"
                return@setOnClickListener
            }
            RetrofitClient.retrofitService.loginUser(email, password)
                .enqueue(object : Callback<RetrofitLoginResponse> {
                    override fun onResponse(
                        call: Call<RetrofitLoginResponse>,
                        response: Response<RetrofitLoginResponse>
                    ) {
                        var strOutput = ""
                        strOutput = "Id : " + response.body()!!.user_id
                        strOutput = """
                            $strOutput
                            Name : ${response.body()!!.message}
                            """.trimIndent()

                        loginBinding.output.setText(strOutput)
                        Toast.makeText(context, response.body()!!.message, Toast.LENGTH_LONG).show()
                        Log.d("msg", password)
                        Log.d("msg", email)

                    }

                    override fun onFailure(call: Call<RetrofitLoginResponse>, t: Throwable) {
                        Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
                    }
                })



            loadFragment(HomeFragment())
            loginBinding.ll.visibility = View.INVISIBLE
        })
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.loginContainer, fragment)
        transaction.addToBackStack(null)

        transaction.commit()
    }


}
