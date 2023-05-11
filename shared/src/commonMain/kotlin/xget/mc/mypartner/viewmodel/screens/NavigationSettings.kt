package xget.mc.mypartner.viewmodel.screens

import io.ktor.client.plugins.logging.LogLevel
import xget.mc.mypartner.viewmodel.ScreenIdentifier
import xget.mc.mypartner.viewmodel.screens.chatScreen.ChatParams

object navigationSettings {
    val homeScreen = Level1Navigation.ChatScreen // the start screen should be specified here
    val saveLastLevel1Screen = true
    val alwaysQuitOnHomeScreen = true
}


// LEVEL 1 NAVIGATION OF THE APP

enum class Level1Navigation(
    val screenIdentifier: ScreenIdentifier,
    val rememberVerticalStack: Boolean = false
) {
    ChatScreen(
        ScreenIdentifier.get(
            Screen.ChatScreen,
            ChatParams(idk = "")
        ), true
    ),
}