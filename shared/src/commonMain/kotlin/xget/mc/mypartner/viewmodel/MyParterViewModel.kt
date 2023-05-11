package xget.mc.mypartner.viewmodel

import kotlinx.coroutines.flow.StateFlow
import xget.mc.mypartner.DebugLogger
import xget.mc.mypartner.repositories.GptRepository
import xget.mc.mypartner.viewmodel.states.AppState
import xget.mc.mypartner.viewmodel.states.StateManager

val debugLogger by lazy { DebugLogger("D-KMP SAMPLE") }


class MyParterViewModel (gptRepo: GptRepository) {

    companion object Factory {
        // factory methods are defined in the platform-specific shared code (androidMain and iosMain)
    }

    val stateFlow: StateFlow<AppState>
        get() = stateManager.mutableStateFlow

    private val stateManager by lazy { StateManager(gptRepo) }
    val navigation by lazy { Navigation(stateManager) }

}