package com.example.shoppinglistapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Home(modifier: PaddingValues) {
    val c1 = Color(0xFF17555D)

    var iname by remember { mutableStateOf("") }
    var iqunty by remember { mutableStateOf("") }
    var showDig  by remember { mutableStateOf(false) }
    var sitems by remember { mutableStateOf(listOf<ShoppingItems>()) }
    var ename by remember { mutableStateOf("") }
    var equnty by remember { mutableStateOf("") }
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { showDig = true },
            modifier = Modifier.padding(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = c1,
                contentColor = Color.White

            )
        ) {
            Text(text = "Add items")
        }
        LazyColumn {
            items(sitems) {
                item ->
//                modify items inside the list
                if(item.isEditing){

                    ShoppingListEditing(item = item,
                        OnEditComplete = {
                            ename , equnty ->
                            sitems = sitems.map { it.copy(isEditing = false) }
                            val editItem = sitems.find { it.id == item.id }
                            editItem?.let{
                                it.itemName = ename
                                it.qunty = equnty
                            }
                        }



                    )

                }
                else{
                    ShoppingListDisplay(item = item,
                        onEdit = {
//                            finding which item is editing and after editing changing it to false
                            sitems = sitems.map { it.copy(isEditing = it.id == item.id) }
                        },

                        onDelete = {
//                            just subtracting our current item from the list
                            sitems = sitems-item
                        })


                }


            }

        }


        if (showDig) {
            AlertDialog(
                onDismissRequest = { showDig = false
                                   },
                title = { Text(text = "Add Item") },
                confirmButton = {
                    Button(onClick = {
                        if (iname.isNotBlank() && iqunty.isNotBlank()){

                            var newitem = ShoppingItems(
                                id = sitems.size+1,
                                itemName = iname,
                                qunty = iqunty.toInt()


                            )
                            sitems = sitems + newitem
                            iname = ""
                            iqunty = ""
                            showDig = false


                        }

                        showDig = false

                    },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = c1,
                            contentColor = Color.White
                        )
                        )

                    {
                        Text(text = "Add")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDig = false }) {
                        Text(text = "Cancel")
                    }
                },
                text = {
                    Column {
                        OutlinedTextField(
                            value = iname,
                            onValueChange = {
                                iname = it
                            },
                            label = { Text(text = "Item Name") },
                            singleLine = true
                        )
                        OutlinedTextField(
                            value = iqunty,
                            onValueChange = {
                                iqunty = it
                            },
                            label = { Text(text = "Item Quantity") },
                            singleLine = true
                        )
                    }
                }
            )
        }
    }
}
