package xget.mc.mypartner.android.composables.navigation

import androidx.compose.runtime.Composable
import xget.mc.mypartner.android.composables.screens.chatscreen.MainChatScreen
import xget.mc.mypartner.viewmodel.Navigation
import xget.mc.mypartner.viewmodel.ScreenIdentifier
import xget.mc.mypartner.viewmodel.screens.Screen
import xget.mc.mypartner.viewmodel.screens.chatScreen.sendMessage
import xget.mc.mypartner.viewmodel.states.ScreenParams


@Composable
fun Navigation.ScreenPicker(
    screenIdentifier: ScreenIdentifier,
    navigate: (Screen, ScreenParams?) -> Unit
) {

    when (screenIdentifier.screen) {

        Screen.ChatScreen ->
            MainChatScreen(
                chatState = stateProvider.get(screenIdentifier),
                events::sendMessage
            )

        else ->
            return

    }

}


