package com.example.mysecondhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mysecondhomework.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var binding: FragmentProfileBinding? = null
    private var adapter: CatAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter() {
        adapter = CatAdapter(
            list = CatRepository.cats,
            glide = Glide.with(this@ProfileFragment),
            onClick = { cat ->
                val bundle = Bundle().apply {
                    putInt("cat_id", cat.id)
                }
                findNavController().navigate(R.id.action_profileFragment_to_catFragment, bundle)
            }
        )

        binding?.apply {
            rvCat.adapter = adapter
            rvCat.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
