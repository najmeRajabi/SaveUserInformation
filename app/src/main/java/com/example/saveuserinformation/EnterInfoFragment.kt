package com.example.saveuserinformation

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.saveuserinformation.databinding.FragmentEnterInfoBinding


class EnterInfoFragment : Fragment() {


    lateinit var binding: FragmentEnterInfoBinding
    lateinit var bundle: Bundle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterInfoBinding.inflate(layoutInflater, container ,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerBtn.setOnClickListener { register() }
    }

    private fun register() {
        if(checkInfo()){
            sendInfo()
            goToFragmentShowInfo()
        }

    }

    private fun goToFragmentShowInfo() {
        findNavController().navigate(R.id.action_enterInfoFragment_to_showInfoFragment , bundle)
    }

    private fun sendInfo() {
        var name = binding.nameEditText.text.toString()
        val username = binding.usernameEditText.text.toString()
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        val gender = if (binding.genderRadioGroup.checkedRadioButtonId == binding.femaleRadioButton.id){
            Gender.Female
        }else{
            Gender.Male
        }
        bundle .putString("name" , name)
        bundle .putString("username" , username)
        bundle .putString("email" , email)
        bundle .putString("password" , password)
        bundle .putString("gender" , gender.name)
    }

    private fun checkInfo():Boolean {
        var result =  false
        when {
            binding.nameEditText.text?.isBlank() == true -> {
                binding.nameEditText.error="Enter your name"
            }
            binding.usernameEditText.text?.isBlank() == true -> {
                binding.usernameEditText.error = " enter username"
            }
            binding.emailEditText.text?.isBlank() == true -> {
                binding.emailEditText.error = "enter email address"
            }
            binding.passwordEditText.text?.isBlank() == true -> {
                binding.passwordEditText.error = " enter a password"
            }
            binding.repeatPasswordEditText.text?.isBlank() == true -> {
                binding.repeatPasswordEditText.error = " repeat password"
            }
            binding.passwordEditText.text.toString() != binding.repeatPasswordEditText.text.toString() -> {
                binding.repeatPasswordEditText.error = " passwords not same"
            }
            else -> result = true
        }
        return result
    }


}
enum class Gender{
    Female , Male
}