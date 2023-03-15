package com.example.tvshowmaster.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvshowappmaster.model.PeopleResponse
import com.example.tvshowappmaster.model.TvShowResponse
import com.example.tvshowmaster.repo.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(
    private val repository: TvShowRepository
) : ViewModel() {

    private var _response = MutableLiveData<TvShowResponse>()
    val tvShowResponse : LiveData<TvShowResponse>
        get() = _response

    private var _responsePeople = MutableLiveData<PeopleResponse>()
    val peopleResponse : LiveData<PeopleResponse>
        get() = _responsePeople

    init {
        getTvShow()
        getPeople()
    }

    private fun getTvShow() = viewModelScope.launch{
        repository.getTvShow().let {
            if (it.isSuccessful){
                _response.postValue(it.body())
            }else{
                Log.d("", "getTvShow: ${it.code()}")
            }
        }
    }

    private fun getPeople() = viewModelScope.launch{
        repository.getPeople().let {
            if (it.isSuccessful){
                _responsePeople.postValue(it.body())
            }else{
                Log.d("", "getPeople: ${it.code()}")
            }
        }

    }
}