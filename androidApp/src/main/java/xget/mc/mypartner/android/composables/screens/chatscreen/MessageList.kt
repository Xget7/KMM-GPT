package xget.mc.mypartner.android.composables.screens.chatscreen

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import xget.mc.mypartner.viewmodel.screens.chatScreen.MessageItem
import xgetmcmypartner.db.Message

@Composable
fun MessageList(
    messageItems: List<Message>,
    modifier: Modifier,
    lazyListState: LazyListState,
) {


    LazyColumn(
        modifier = modifier,
        state = lazyListState,
        reverseLayout = false,
    ) {
        itemsIndexed(messageItems) { i, message ->
            MessageCard(
                message.toItem(),
            )

        }


    }
}

fun Message.toItem(): MessageItem {
    return MessageItem(
        message, author, date
    )
}



//BEST IU AND SWIFT INTEGRATION