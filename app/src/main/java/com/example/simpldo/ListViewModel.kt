package com.example.simpldo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {

    var todo: MutableLiveData<MutableList<ListItem>> = MutableLiveData<MutableList<ListItem>>()

    init {
        todo.value = mutableListOf<ListItem>()
    }

    fun addItem(item: ListItem) {
        todo.value?.add(item)
        todo.value = todo.value
    }

    fun updateItem(pos: Int, item: ListItem) {
        todo.value?.set(pos, item)
        todo.value = todo.value
    }

    fun removeItem(pos: Int) {
        todo.value?.removeAt(pos)
        todo.value = todo.value
    }

}