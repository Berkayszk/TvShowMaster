package com.example.tvshowmaster.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tvshowmaster.R
import com.example.tvshowmaster.adapter.PeopleAdapter
import com.example.tvshowmaster.adapter.TvShowAdapter
import com.example.tvshowmaster.databinding.FragmentTvShowBinding
import com.example.tvshowmaster.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TvShowFragment : Fragment(R.layout.fragment_tv_show) {

    private var _binding : FragmentTvShowBinding?=null
    private val binding get() = _binding!!
    private lateinit var tvShowAdapter : TvShowAdapter
    private lateinit var peopleAdapter : PeopleAdapter
    private val viewModel : TvShowViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRvTvShow()
    }
    private fun setupRvTvShow(){
        tvShowAdapter = TvShowAdapter()
        //peopleAdapter = PeopleAdapter()

       binding.recyclerView.apply {
           adapter = tvShowAdapter
           layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
           setHasFixedSize(true)
       }
        /*
        binding.recyclerViewPeople.apply {
            adapter = peopleAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)
        }



        binding.recyclerViewEpisode.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)
        }

         */


        viewModel.tvShowResponse.observe(viewLifecycleOwner, Observer{
            tvShowAdapter.tvshow = it
        })/*
        viewModel.peopleResponse.observe(viewLifecycleOwner, {people ->
            peopleAdapter.people = people
        })

        */

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}