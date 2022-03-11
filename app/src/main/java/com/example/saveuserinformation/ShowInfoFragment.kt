package com.example.saveuserinformation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.saveuserinformation.databinding.FragmentShowInfoBinding

class ShowInfoFragment : Fragment() {

    lateinit var binding: FragmentShowInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowInfoBinding.inflate(layoutInflater,container,false)

        var name = requireArguments().getString("name")
        var username = requireArguments().getString("username")
        var email = requireArguments().getString("email")
        var password = requireArguments().getString("password")
        var gender = requireArguments().getString("gender")

        binding.nameTxv.text = name
        binding.usernameTxv.text =username
        binding.emailTxv.text = email
        binding.passwordTxv.text = password
        binding.genderTxv.text = gender

        binding.hideInfoBtn.setOnClickListener {
            saveInShare()
            finish()
        }
        return binding.root
    }

    private fun finish() {
        activity?.onBackPressed()
    }

    private fun saveInShare() {

        val sharedPreferences = activity?.getSharedPreferences("userInfo" , Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putString("NAME" ,binding.nameTxv.text.toString())
        editor?.putString("USERNAME" ,binding.usernameTxv.text.toString())
        editor?.putString("PASSWORD" ,binding.passwordTxv.text.toString())
        editor?.putString("EMAIL" ,binding.emailTxv.text.toString())
        editor?.putString("GENDER" ,binding.genderTxv.text.toString())
        Toast.makeText(activity,"saved " , Toast.LENGTH_SHORT).show()
    }


}