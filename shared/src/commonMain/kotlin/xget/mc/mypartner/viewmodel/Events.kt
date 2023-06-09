package xget.mc.mypartner.viewmodel

import xget.mc.mypartner.DebugLogger
import xget.mc.mypartner.viewmodel.states.StateManager

class Events (val stateManager : StateManager) {
    val debugLogger = DebugLogger("Events")


    val dataRepository
        get() = stateManager.dataRepository

    // we run each event function on a Dispatchers.Main coroutine
    fun screenCoroutine (block: suspend () -> Unit) {
        debugLogger.log("/"+stateManager.currentScreenIdentifier.URI+": an Event is called")
        stateManager.runInScreenScope { block() }
    }

}