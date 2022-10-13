package com.kamiz.rappiapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kamiz.rappiapp.data.RappiRepository
import com.kamiz.rappiapp.data.model.Category
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: RappiRepository,
) : ViewModel() {
    val categoryList: MutableLiveData<List<Category>> = MutableLiveData(listOf())

    init {
        getCategories()
    }

    fun getCategories(){
        viewModelScope.launch {
            categoryList.value = repository.getCategories()
        }
    }
}