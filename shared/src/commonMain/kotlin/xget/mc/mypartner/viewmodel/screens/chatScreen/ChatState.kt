package xget.mc.mypartner.viewmodel.screens.chatScreen

import xget.mc.mypartner.data.model.GptChatCompletionResponse
import xget.mc.mypartner.viewmodel.states.ScreenState
import xgetmcmypartner.db.Message

data class ChatState(
    val isLoading : Boolean = false,
    val gptLoading : Boolean = false,
    val messages : List<Message> = mutableListOf(),
) : ScreenState


data class MessageItem (
    val message: String,
    val author : String,
    val date : String
){
    fun isMine()  = author == "me"
}