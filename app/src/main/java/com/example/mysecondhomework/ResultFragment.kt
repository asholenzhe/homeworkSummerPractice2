package com.example.mysecondhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.example.mysecondhomework.databinding.FragmentResultBinding



class ResultFragment : Fragment(R.layout.fragment_result) {


        private var binding: FragmentResultBinding? = null

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding = FragmentResultBinding.bind(view)
            val etName = arguments?.getString(ARG_NAME) ?: "ERROR"

            binding?.run {
                titleResult.text = " ${titleResult.text}  \n $etName"
            }
        }

        override fun onDestroyView() {
            super.onDestroyView()
            binding = null
        }

        companion object {

            private const val ARG_NAME= "NAME"


            fun bundle(etName: String): Bundle = Bundle().apply {
                putString(ARG_NAME, etName)

            }
        }

}