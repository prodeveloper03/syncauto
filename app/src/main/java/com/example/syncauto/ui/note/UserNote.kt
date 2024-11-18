package com.example.syncauto.ui.note

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserNote(
    text :  String,
    onTextChange : (String) -> Unit,
    modifier: Modifier = Modifier
){
    val maxWord = 80
    TextField(
        value = text,
        onValueChange = { newText ->
            // Limit the input to a maximum of 80 words
            val words = newText.split(" ").filter { it.isNotBlank() }
            if (words.size <= maxWord) {
                onTextChange(newText)
            }
        },
        placeholder = { Text("Write up to 80 words...") },
        modifier = modifier
            .size(width = 340.dp, height = 300.dp)
            .padding(8.dp),
        maxLines = 3,
        singleLine = false
    )

}