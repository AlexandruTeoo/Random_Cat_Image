package com.example.randomcatimage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RandomCatViewModel:ViewModel() {

    private val _randomCat = MutableStateFlow<String?>(null)
    val randomCat: StateFlow<String?> get() = _randomCat

    init{
        fetchRandomCat()
    }

    fun fetchRandomCat(){
        viewModelScope.launch{
            val randomCatApi = RandomCatAPI.getInstance()
            try{
                val randomCatImg = randomCatApi.getRandomCat()
                _randomCat.value = randomCatImg[0].url
            }
            catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}