package com.example.tvshowmaster.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.tvshowappmaster.model.TvShowResponseItem
import com.example.tvshowmaster.R
import com.example.tvshowmaster.databinding.FragmentWebViewBinding


class WebViewFragment : Fragment(R.layout.fragment_web_view) {
    private var _binding : FragmentWebViewBinding?=null
    private val binding get() = _binding!!
    private val args : WebViewFragmentArgs by navArgs()
    private lateinit var tvShow : TvShowResponseItem



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWebViewBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvShow = args.tvwebView
        setUpWebView()
    }
    private fun setUpWebView(){
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(tvShow.url)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}