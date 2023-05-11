package xget.mc.mypartner.viewmodel.states

import xget.mc.mypartner.viewmodel.ScreenIdentifier

class StateProvider (val stateManager : StateManager) {

    inline fun <reified T: ScreenState> get(screenIdentifier: ScreenIdentifier) : T {
        return getScreenState(screenIdentifier) as T
    }

    // reified functions cannot be exported to iOS, so we use this function returning the "ScreenState" interface type
    // on Swift, we then need to cast it to the specific state class
    fun getToCast(screenIdentifier: ScreenIdentifier) : ScreenState {
        return getScreenState(screenIdentifier)
    }

    inline fun <reified T: ScreenState> getScreenState(screenIdentifier: ScreenIdentifier) : T {
        //debugLogger.log("getScreenState: "+screenIdentifier.URI)
        return stateManager.screenStatesMap[screenIdentifier.URI] as T
    }

}