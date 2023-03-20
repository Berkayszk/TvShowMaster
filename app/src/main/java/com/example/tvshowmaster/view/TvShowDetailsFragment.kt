package com.example.tvshowmaster.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.tvshowappmaster.model.PeopleResponseItem
import com.example.tvshowappmaster.model.TvShowResponse
import com.example.tvshowappmaster.model.TvShowResponseItem
import com.example.tvshowmaster.R
import com.example.tvshowmaster.databinding.FragmentTvShowBinding
import com.example.tvshowmaster.databinding.FragmentTvShowDetailsBinding


class TvShowDetailsFragment : Fragment(R.layout.fragment_tv_show_details) {
    private var _binding : FragmentTvShowDetailsBinding?=null
    private val binding get() = _binding!!
    private val args: TvShowDetailsFragmentArgs by navArgs()
    private lateinit var tvshow: TvShowResponseItem


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentTvShowDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvshow= args.tvshow
        populateUI()

    }
    private fun populateUI(){
        binding.apply {
            tvshowText.text = tvshow.name
            genresText.text = tvshow.genres.toString()
            languageText.text = tvshow.language
            runtimeText.text = tvshow.runtime.toString()
            ratingText.text = tvshow.rating.average.toString()
            statusText.text = tvshow.status
            imageView2.load(tvshow.image.original){
                crossfade(1000)
                crossfade(true)
            }
            button.setOnClickListener {webView->
                val direction = TvShowDetailsFragmentDirections.actionTvShowDetailsFragmentToWebViewFragment(tvshow)
                webView.findNavController().navigate(direction)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding =null
    }

}