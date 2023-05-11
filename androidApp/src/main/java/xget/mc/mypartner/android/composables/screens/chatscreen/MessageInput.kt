package xget.mc.mypartner.android.composables.screens.chatscreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun MessageInput(
    sendMessage: (String) -> Unit
) {
    var inputValue by remember { mutableStateOf("") }

    fun sendMessage() {
        sendMessage(inputValue)
        inputValue = ""
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp, end = 12.dp),
            value = inputValue,
            placeholder = { Text(text = "Enter Message") },
            onValueChange = { inputValue = it },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
            keyboardActions = KeyboardActions { sendMessage() },
            shape = RoundedCornerShape(45)
        )

        IconButton(
            modifier = Modifier.height(60.dp),
            onClick = { sendMessage() },
            enabled = inputValue.isNotBlank(),
        ) {
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "",
                modifier = Modifier.size(40.dp),
                tint = if (inputValue.isNotBlank()) MaterialTheme.colors.secondary else Color.LightGray
            )
        }

    }
}