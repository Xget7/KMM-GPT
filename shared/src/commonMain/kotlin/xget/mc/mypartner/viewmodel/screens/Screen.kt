package xget.mc.mypartner.viewmodel.screens

import xget.mc.mypartner.viewmodel.ScreenIdentifier
import xget.mc.mypartner.viewmodel.screens.chatScreen.initChat
import xget.mc.mypartner.viewmodel.states.StateManager


enum class Screen(
    val asString: String,
    val navigationLevel: Int = 1,
    val initSettings: StateManager.(ScreenIdentifier) -> ScreenInitSettings,
) {


    ChatScreen("chat_screen", 1, { initChat(it.params()) })

}