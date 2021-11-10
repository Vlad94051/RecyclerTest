package ru.tms.recyclertest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.tms.recyclertest.data.DataSource
import ru.tms.recyclertest.domain.ChatInteractor
import ru.tms.recyclertest.presentation.recycler.Chat

class ChooseMessageViewModel(private val interactor: ChatInteractor) : ViewModel() {

    val messages: LiveData<List<Chat>> get() = _messages
    private val _messages = MutableLiveData<List<Chat>>(interactor.loadMessages())

    val listOrientation: LiveData<Int> get() = _listOrientation
    private val _listOrientation = MutableLiveData<Int>(interactor.loadOrientation())
}