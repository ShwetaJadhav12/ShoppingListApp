package com.example.shoppinglistapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ShoppingListDisplay(
    item:ShoppingItems,
    onEdit: () -> Unit,
    onDelete: () -> Unit

) {
    val c1 = Color(0xFF17555D)
    val c2 = Color(0xFF8DBBC0)
    val cardShape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp) // Margins
            .clip(cardShape)
            .border(width = 1.dp, color = c1, shape = cardShape),
        shape = cardShape,
        colors = CardDefaults.cardColors(
            containerColor = c2,
            contentColor = c1
        )
    ){


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Text(
                text = item.itemName,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(18.dp))
            Text(
                text = "Quantity: " + item.qunty.toString(),
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
            Row {
                IconButton(
                    onClick =  onEdit

                ){
                    Icon(
                        imageVector = androidx.compose.material.icons.Icons.Default.Create,
                        contentDescription = "Edit",
                        tint = Color.Black

                    )

                }
                IconButton(
                    onClick =  onDelete

                ){
                    Icon(
                        imageVector = androidx.compose.material.icons.Icons.Default.Delete,
                        contentDescription = "Edit",
                        tint = Color.Black

                    )

                }
            }



        }
    }
}