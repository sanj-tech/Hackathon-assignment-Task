package com.example.digitalflakedemo.fragments

import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.digitalflakedemo.R
import com.example.digitalflakedemo.databinding.FragmentSignUpBinding
import com.example.digitalflakedemo.retrofit.RetrofitClient
import com.example.digitalflakedemo.retrofitmodels.RetrofitResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentSignUpBinding.inflate(LayoutInflater.from(context))
        val view: View = binding.root

        return view
        // Inflate the layout for this fragment

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignUp.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmailId.text.toString()
            val contactNo = binding.etMobileNumber.text.toString()
            //val password = binding.etPassword.text.toString()
            if (name.isEmpty()) {
                binding.etName.error = "Name required"
                return@setOnClickListener
            }
            if (email.isEmpty()) {
                binding.etEmailId.error = "email required"
                return@setOnClickListener
            }

            RetrofitClient.retrofitService.createAccount(email, name,contactNo)
                .enqueue(object : Callback<RetrofitResponse> {
                    override fun onResponse(
                        call: Call<RetrofitResponse>, response: Response<RetrofitResponse>
                    ) {
                        var strOutput = ""
                        strOutput = "UserId : " + response.body()!!.user_id
                        strOutput = """
                            $strOutput
                            Name : ${response.body()!!.message}
                            """.trimIndent()
                        //binding.tv.setText(strOutput)

                        Log.d("msg", name)
                        Log.d("msg", email)
                        Log.d("msg", contactNo)
                         Toast.makeText(context, response.body()!!.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onFailure(call: Call<RetrofitResponse>, t: Throwable) {
                        Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
                    }
                })


        }
        callText()
    }


    private fun callText() {
        binding.tvLogin.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        binding.tvLogin.setOnClickListener({
            loadFragment(LoginFragment())
            binding.llSignUP.visibility = View.INVISIBLE


        })

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flLogin, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}





