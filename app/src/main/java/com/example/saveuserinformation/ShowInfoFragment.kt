package com.example.saveuserinformation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return binding.root
    }

}