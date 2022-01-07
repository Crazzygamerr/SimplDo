package com.example.simpldo

import java.io.Serializable

data class ListItem(var content: String,var isComplete: Boolean = false):Serializable

