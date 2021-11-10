package ru.tms.recyclertest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import org.koin.core.scope.Scope
import org.koin.ext.scope
import ru.tms.recyclertest.domain.ChatInteractor
import ru.tms.recyclertest.presentation.recycler.Chat

class ChooseMessageViewModel(private val interactor: ChatInteractor) : ViewModel() {

    val messages: LiveData<List<Chat>> get() = _messages
    private val _messages = MutableLiveData<List<Chat>>()

    val listOrientation: LiveData<Int> get() = _listOrientation
    private val _listOrientation = MutableLiveData(interactor.loadOrientation())

    private val scope = CoroutineScope(Dispatchers.Main)

    fun loadMessages() {
        scope.launch {
            _messages.value = interactor.loadMessages()
        }
    }
}