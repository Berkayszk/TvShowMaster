package com.example.tvshowmaster.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.tvshowappmaster.model.TvShowResponseItem
import com.example.tvshowmaster.databinding.TvshowRowBinding
import com.example.tvshowmaster.view.TvShowFragmentDirections

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private lateinit var peopleAdapter : PeopleAdapter
    inner class TvShowViewHolder(val binding : TvshowRowBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<TvShowResponseItem>(){
        override fun areItemsTheSame(
            oldItem: TvShowResponseItem,
            newItem: TvShowResponseItem
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: TvShowResponseItem,
            newItem: TvShowResponseItem
        ): Boolean {
            return oldItem==newItem
        }

    }
    private val differ = AsyncListDiffer(this,diffCallBack)
    var tvshow : List<TvShowResponseItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(TvshowRowBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return tvshow.size
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val currentTvShow = tvshow[position]

        holder.binding.apply {
            textView.text = currentTvShow.name
            imageView.load(currentTvShow.image.original){
                crossfade(true)
                crossfade(1000)
            }
        }

        holder.itemView.setOnClickListener {
            val direction =TvShowFragmentDirections.actionTvShowFragmentToTvShowDetailsFragment(currentTvShow,peopleAdapter.people[position])
            it.findNavController().navigate(direction)
        }

    }
}