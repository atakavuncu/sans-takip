package com.example.sanstakip.ui.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sanstakip.R
import com.example.sanstakip.databinding.FragmentHomePageBinding
import com.example.sanstakip.model.SayisalSuperModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment() {

    private lateinit var binding: FragmentHomePageBinding
    private val viewModel: HomePageViewModel by viewModels()
    private var list = ArrayList<SayisalSuperModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel

        viewModel.event.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { it1 ->
                listenEvents(it1)
            }
        }

        fetchAndSetData("sayisaloto")
        fetchAndSetData("superloto")

        binding.sayisalButton.setOnClickListener{
            changeVisibility(binding.sayisalRecyclerView, binding.sayisalArrowIcon)
        }

        binding.superButton.setOnClickListener{
            changeVisibility(binding.superRecyclerView, binding.superArrowIcon)
        }

        return binding.root
    }

    private fun listenEvents(event: HomePageEvent) {
        when (event) {
            is HomePageEvent.SelectedLotoModel -> openSelectedLotoDetail(event.data)
        }
    }

    private fun openSelectedLotoDetail(model: SayisalSuperModel) {
        val direction = HomePageFragmentDirections.actionHomePageFragmentToDetailFragment(model)
        findNavController().navigate(direction)
    }

    private fun setsayisalLotoList() {
        binding.sayisalList = list
    }

    private fun setsuperLotoList() {
        binding.superList = list
    }

    private fun fetchAndSetData(type: String) {
        val dataModelLiveData = viewModel.fetchData(type)
        dataModelLiveData.observe(requireActivity()) {
            if (it.isNotEmpty()) {
                if (type == "sayisaloto") {
                    list = it
                    setsayisalLotoList()
                }
                if (type == "superloto") {
                    list = it
                    setsuperLotoList()
                }
            }
        }
    }

    private fun changeVisibility(recyclerView: RecyclerView, icon: ImageView){
        if (recyclerView.visibility == View.VISIBLE) {
            recyclerView.visibility = View.GONE
            icon.setImageResource(R.drawable.baseline_keyboard_arrow_up_24)
        } else {
            recyclerView.visibility = View.VISIBLE
            icon.setImageResource(R.drawable.baseline_keyboard_arrow_down_24)
        }
    }
}
