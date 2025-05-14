package com.example.shoppinglistapp

data class ShoppingItems(
    val id: Int,
    var itemName: String,
    var qunty: Int,
    val isEditing: Boolean = false,
)
