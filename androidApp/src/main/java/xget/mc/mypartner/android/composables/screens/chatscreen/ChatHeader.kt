package xget.mc.mypartner.android.composables.screens.chatscreen

import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatHeader() {
    Row(
        modifier = Modifier.fillMaxWidth().height(50.dp).background(Color.LightGray)
            .padding(start = 10.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Chat with GPT4", fontSize = 26.sp)
        }

    }
}