package com.example.shoppinglistapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
    item: ShoppingItems,
    OnEditComplete: (String, Int) -> Unit
) {
    var ename by remember { mutableStateOf(item.itemName) }
    var equnty by remember { mutableStateOf(item.qunty.toString()) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .background(
                color = androidx.compose.ui.graphics.Color(0xFF17555D),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
            )
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            BasicTextField(
                value = ename,
                onValueChange = { ename = it },

                modifier = Modifier
                    .background(androidx.compose.ui.graphics.Color.White,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                    .padding(8.dp).width(130.dp)

            )
            Spacer(modifier = Modifier.height(8.dp))
            BasicTextField(
                value = equnty,
                onValueChange = { equnty = it },
                modifier = Modifier
                    .background(androidx.compose.ui.graphics.Color.White,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                    .padding(8.dp).width(130.dp)
            )
        }

        Spacer(modifier = Modifier.weight(0.1f))

        Button(
            onClick = {
                OnEditComplete(ename, equnty.toIntOrNull() ?: 1)
            },
            modifier = Modifier.padding(8.dp).size(130.dp , 40.dp),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = androidx.compose.ui.graphics.Color(0xFF8DBBC0),
                contentColor = androidx.compose.ui.graphics.Color.Black
            )
        ) {
            Text(text = "Save")
        }
    }
}
