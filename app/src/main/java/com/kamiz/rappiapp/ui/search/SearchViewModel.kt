package com.kamiz.rappiapp.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kamiz.rappiapp.data.RappiRepository
import com.kamiz.rappiapp.data.model.Product
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: RappiRepository,
) : ViewModel() {
    val productList : MutableLiveData<List<Product>> = MutableLiveData()

    fun searchText(searchWord: String) {
        viewModelScope.launch {
             productList.value = repository.searchText(searchWord)
        }
    }
}