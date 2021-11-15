package ru.tms.recyclertest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// SharedView model
class FilterSharedViewModel: ViewModel() {
    private val _filterLiveData = MutableLiveData<String>()
    val filterLiveData: LiveData<String> get() = _filterLiveData

    fun setFilter(filter: String) {
        _filterLiveData.value = filter
    }
}