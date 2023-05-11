package xget.mc.mypartner.android.composables.screens.chatscreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xget.mc.mypartner.android.composables.screens.LoadingScreen
import xget.mc.mypartner.viewmodel.screens.chatScreen.ChatState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainChatScreen(
    chatState: ChatState,
    onSendMessage: (String) -> Unit,
) {
    val state = rememberLazyListState()

    if (chatState.isLoading) {
        LoadingScreen()
    } else {

        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            if (chatState.messages.isEmpty()) {
                Text(
                    text = "No messages",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                )
            } else {

                MessageList(
                    chatState.messages.filter { it.message.isNotBlank() }.sortedBy { it.date },
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = 12.dp),
                    lazyListState = state,
                )

            }
            MessageInput {
                onSendMessage(it)
            }

            LaunchedEffect(chatState.messages) {
                state.animateScrollToItem(chatState.messages.lastIndex)
            }

        }
    }

}