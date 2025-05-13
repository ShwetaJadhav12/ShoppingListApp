package com.example.shoppinglistapp

data class ShoppingItems(
    val id: Int,
    val itemName: String,
    val qunty: Int,
    val isEditing: Boolean = false,
)
