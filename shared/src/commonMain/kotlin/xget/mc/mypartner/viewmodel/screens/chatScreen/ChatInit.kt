package xget.mc.mypartner.viewmodel.screens.chatScreen

import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import xget.mc.mypartner.data.sources.local.chat.getAllMessages
import xget.mc.mypartner.viewmodel.screens.CallOnInitValues
import xget.mc.mypartner.viewmodel.screens.ScreenInitSettings
import xget.mc.mypartner.viewmodel.states.ScreenParams
import xget.mc.mypartner.viewmodel.states.StateManager


@Serializable // Note: ScreenParams should always be set as Serializable
data class ChatParams(val idk : String) :
    ScreenParams

fun StateManager.initChat(params: ChatParams) = ScreenInitSettings(
    title = "Chat with GPT",
    initState = { ChatState(isLoading = true) },
    callOnInit = {
        // update state, after retrieving data from the repository
        val chatMessages = dataRepository.localDb.getAllMessages()

        delay(1000)
        updateScreen(ChatState::class) {
            it.copy(
                isLoading = false,
                messages = chatMessages
            )
        }
    },
    callOnInitAtEachNavigation = CallOnInitValues.CALL_BEFORE_SHOWING_SCREEN
    // enabling in this way favourites can refresh at each navigation
    // CALL_BEFORE_SHOWING_SCREEN is used, as favourites come from the local storage and not from the network
    // (for more information about "callOnInitAtEachNavigation" values, look at "ScreenInitSettings" class definition)
)