package com.example.sanstakip.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sanstakip.R
import com.example.sanstakip.databinding.DrawCardBinding
import com.example.sanstakip.databinding.FragmentDetailBinding
import com.example.sanstakip.databinding.FragmentHomePageBinding
import com.example.sanstakip.model.SayisalSuperModel
import com.example.sanstakip.ui.homepage.HomePageEvent
import com.example.sanstakip.ui.homepage.HomePageFragmentDirections
import com.example.sanstakip.ui.homepage.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailPageViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()
    private var model = SayisalSuperModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        model = args.lotoModel
        binding.model = model
        viewModel.fetchDetailData(model.setTypeName(), model.drawNumber!!, 2023)

        viewModel.detailModelLiveData.observe(requireActivity()) {
            binding.results = it.tableResult
        }

        return binding.root
    }

}