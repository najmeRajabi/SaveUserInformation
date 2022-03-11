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
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_show_info, container, false)
        return binding.root
    }

}