package com.example.shoppinglistapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingListEditing(
    item:ShoppingItems,
    OnEditComplete: (String, Int) -> Unit
)
{
    var ename by remember { mutableStateOf(item.itemName) }
    var equnty by remember { mutableStateOf(item.qunty.toString()) }
    var isEditing by remember { mutableStateOf(item.isEditing) }


    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp).padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp).background(
            color = androidx.compose.ui.graphics.Color(0xFF17555D),
            shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
        )
    ){
        Column()

        {
            BasicTextField(
                value = ename,
                onValueChange = { ename = it },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            BasicTextField(
                value = equnty,
                onValueChange = { equnty = it },
                modifier = Modifier.weight(1f)
            )

        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                OnEditComplete(ename, equnty.toIntOrNull() ?: 1)
//                IF NULL then by default 1,if written something in gibberish then also save as 1
                isEditing = false
            }
        ){
            Text(text = "Save")

        }
    }

}
