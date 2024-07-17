package com.example.syncauto.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Chip(
    text : String,
    isSelected : Boolean = false,
    onSelectedChanged : (String) -> Unit,
    modifier: Modifier = Modifier
){
    Surface (
        modifier = Modifier
            .padding(4.dp)
            .clickable { onSelectedChanged(text) },
        shape = RoundedCornerShape(16.dp),
        color = if (isSelected) {MaterialTheme.colorScheme.primary} else {Color.LightGray}
    ){
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ){

            Text(
                text = text,
                color = if (isSelected) Color.White else Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )


        }
    }

}