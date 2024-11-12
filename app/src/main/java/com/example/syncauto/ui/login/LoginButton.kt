package com.example.syncauto.ui.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginButton(){
    Box(
        modifier = Modifier
            .height(152.dp)
            .width(152.dp)
    ){
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(52.dp)
                .width(132.dp)
                .padding(2.dp)
        ) {
            Text(text = "Login")
        }
    }
}
@Composable
@Preview
fun LoginButtonPreview(){
    LoginButton()
}