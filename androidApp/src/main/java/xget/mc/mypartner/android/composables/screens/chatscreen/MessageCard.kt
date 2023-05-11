package xget.mc.mypartner.android.composables.screens.chatscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import xget.mc.mypartner.android.R
import xget.mc.mypartner.android.utils.Utils.getDateTime
import xget.mc.mypartner.viewmodel.screens.chatScreen.MessageItem
import java.util.regex.Pattern

@Composable
fun MessageCard(messageItem: MessageItem) { // 1
    val currentMessageTime = getDateTime(messageItem.date)



    if (messageItem.message == "-LOADING-LOADING") {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            if (!messageItem.isMine()) {
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.gptlogo),
                        modifier = Modifier
                            .size(20.dp)
                            .padding(3.dp),
                        contentDescription = "GPT LOGO"
                    )
                    Text(
                        text = "GPT 3.5",
                        fontSize = 14.sp,
                    )
                }

            }


            Card(
                modifier = Modifier.widthIn(max = 340.dp),
                shape = cardShapeFor(messageItem), // 3
                backgroundColor = when {
                    messageItem.isMine() -> MaterialTheme.colors.primary
                    else -> Color(0xFFE0E0E6)
                },
            ) {
                TypewriterText(texts = listOf("...", "...", "..."))

            }
        }

    } else {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalAlignment = when { // 2
                messageItem.isMine() -> Alignment.End
                else -> Alignment.Start
            },
        ) {
            if (!messageItem.isMine()) {
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.gptlogo),
                        modifier = Modifier
                            .size(20.dp)
                            .padding(3.dp),
                        contentDescription = "GPT LOGO"
                    )
                    Text(
                        text = "GPT 3.5",
                        fontSize = 14.sp,
                    )
                }

            }


            Card(
                modifier = Modifier.widthIn(max = 340.dp),
                shape = cardShapeFor(messageItem), // 3
                backgroundColor = when {
                    messageItem.isMine() -> MaterialTheme.colors.primary
                    else -> Color(0xFFE0E0E6)
                },
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = messageItem.message,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = when {
                        messageItem.isMine() -> MaterialTheme.colors.onPrimary
                        else -> Color.Black.copy(alpha = 0.9f)
                    },
                )

            }
            if (currentMessageTime != null) {
                Text(text = currentMessageTime, fontSize = 11.sp)
            }

        }
    }


}

@Composable
fun cardShapeFor(message: MessageItem): RoundedCornerShape {
    val roundedCorners = RoundedCornerShape(16.dp)
    return when {
        message.isMine() -> roundedCorners.copy()
        else -> roundedCorners.copy()
    }
}

@Composable
fun TypewriterText(
    texts: List<String>,
) {
    val textIndex = remember {
        mutableStateOf(0)
    }
    val textToDisplay = remember {
        mutableStateOf("")
    }

    LaunchedEffect(
        key1 = texts,
    ) {
        while (textIndex.value < texts.size) {
            texts[textIndex.value].forEachIndexed { charIndex, _ ->
                textToDisplay.value = texts[textIndex.value]
                    .substring(
                        startIndex = 0,
                        endIndex = charIndex + 1,
                    )
                delay(160)
            }
            textIndex.value = (textIndex.value + 1) % texts.size
            delay(1000)
        }
    }

    Text(
        modifier = Modifier.padding(10.dp),
        text = textToDisplay.value,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        color = Color.Black.copy(alpha = 0.9f),
    )
}