package com.example.simpldo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {

    private val _todo = MutableLiveData<MutableList<ListItem>>()
    val todo: LiveData<MutableList<ListItem>> = _todo

    init {
        _todo.value = mutableListOf<ListItem>()
    }

    fun addItem(item: ListItem) = _todo.value?.add(item)

    fun updateItem(pos: Int, item: ListItem) = _todo.value?.set(pos, item)

    fun removeItem(pos: Int) = _todo.value?.removeAt(pos)

}