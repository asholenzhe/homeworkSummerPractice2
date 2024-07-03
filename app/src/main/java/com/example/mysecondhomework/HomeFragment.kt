package com.example.mysecondhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.mysecondhomework.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var binding: FragmentHomeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding?.apply {
            buttonText.setOnClickListener {
                val input = etName.text.toString().trim()
                if(input.isEmpty()){
                    Snackbar.make(view, "Заполните поле! ", Snackbar.LENGTH_SHORT).show()
                }
                else {
                    findNavController().navigate(
                        resId = R.id.action_homeFragment_to_resultFragment,
                        args = ResultFragment.bundle(
                            etName = input
                        )
                    )
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}

