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
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { showDig = true },
            modifier = Modifier.padding(16.dp),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = c1,
                contentColor = Color.White

            )
        ) {
            Text(text = "Add items")
        }
        LazyColumn {
            items(sitems) {
                item ->
                Card(

                    modifier = Modifier.padding(8.dp).fillMaxWidth().height(70.dp),
                    colors = androidx.compose.material3.CardDefaults.cardColors(
                        containerColor = Color.White,
                        contentColor = c1
                    ),
                    elevation = androidx.compose.material3.CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    ),
                    border = androidx.compose.material3.CardDefaults.outlinedCardBorder(
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "Product Name: "+item.itemName,
                            fontSize = androidx.compose.material3.MaterialTheme.typography.titleMedium.fontSize,
                            fontWeight = androidx.compose.material3.MaterialTheme.typography.titleMedium.fontWeight,
                            fontFamily = androidx.compose.material3.MaterialTheme.typography.titleMedium.fontFamily,
                            fontStyle = androidx.compose.material3.MaterialTheme.typography.titleMedium.fontStyle)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = item.qunty.toString())
                    }
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

                            sitems = sitems + ShoppingItems(
                                id = sitems.size + 1,
                                itemName = iname,
                                qunty = iqunty.toInt()
                            )


                        }

                        showDig = false

                    }) {
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
