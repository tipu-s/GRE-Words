package com.example.grehighfrequencywords.feed.viewmodel

import androidx.lifecycle.*
import com.example.grehighfrequencywords.feed.data.MyRepository
import com.example.grehighfrequencywords.feed.data.Word
import kotlinx.coroutines.launch

class WordFragmentViewModel(private val myRepository: MyRepository) : ViewModel() {
    private val _wordList = MutableLiveData<List<Word>>()
    val wordList: LiveData<List<Word>> = _wordList

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> = _error

    fun loadData() {
        viewModelScope.launch {
            try {
                val result = myRepository.getGreData()
                _wordList.value = result?.greWords
            } catch (e: Exception) {
                _error.value = e
            }
        }
    }
}