package xget.mc.mypartner.viewmodel.screens.chatScreen

import kotlinx.datetime.Clock
import xget.mc.mypartner.data.sources.local.chat.deleteLoadingMessage
import xget.mc.mypartner.data.sources.local.chat.getAllMessages
import xget.mc.mypartner.data.sources.local.chat.insertMessage
import xget.mc.mypartner.data.sources.remote.functions.sendTextForCompletion
import xget.mc.mypartner.viewmodel.Events
import xgetmcmypartner.db.Message

fun Events.sendMessage(message: String) = screenCoroutine {
    val currentTimeUnix = Clock.System.now().epochSeconds
    val local = dataRepository.localDb


    local.insertMessage(
        Message(
            0,
            author = "me",
            message = message,
            date = currentTimeUnix.toString()
        )
    )
    local.insertMessage(
        Message(
            0,
            author = "GPT",
            message = "-LOADING-LOADING",
            date = currentTimeUnix.toString()
        )
    )
    stateManager.updateScreen(ChatState::class) {
        it.copy(messages = local.getAllMessages(), gptLoading = true)
    }

    //get RESPONSE
    val chatResponse = dataRepository.sendTextForCompletion(message)

    local.deleteLoadingMessage()
    local.insertMessage(
        Message(
            0,
            author = "GPT",
            message = chatResponse?.choices?.first()?.messageDto?.content ?: "No response",
            date = currentTimeUnix.toString()
        )
    )
    debugLogger.log("KTOR RESPONSE: " + chatResponse.toString())
    stateManager.updateScreen(ChatState::class) {
        it.copy(messages = local.getAllMessages(), gptLoading = false)
    }
}