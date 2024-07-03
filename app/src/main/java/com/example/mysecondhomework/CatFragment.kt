package com.example.mysecondhomework

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.mysecondhomework.databinding.FragmentCatBinding

class CatFragment : Fragment(R.layout.fragment_cat) {
    private var binding: FragmentCatBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCatBinding.bind(view)

        val catId = arguments?.getInt("cat_id") ?: -1
        val cat = CatRepository.cats.find { it.id == catId }

        binding?.apply {
            cat?.let {
                tvName.text = it.name
                Glide.with(this@CatFragment)
                    .load(it.url)
                    .error(R.drawable.baseline_error_24)
                    .placeholder(R.drawable.baseline_cloud_download_24)
                    .into(ivImage)
                tvBreed.text = it.breed
                tvShortDescription.text = it.shortDescription
                Description.text = it.longDescription
            }

            button.setOnClickListener {
                findNavController().navigate(R.id.action_catFragment_to_profileFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
