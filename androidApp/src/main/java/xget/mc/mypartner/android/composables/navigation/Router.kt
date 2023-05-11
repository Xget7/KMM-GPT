package xget.mc.composables.navigation

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.unit.dp
import xget.mc.mypartner.android.composables.navigation.templates.OnePane
import xget.mc.mypartner.viewmodel.Navigation
import xget.mc.mypartner.viewmodel.NavigationState
import xget.mc.mypartner.viewmodel.ScreenIdentifier
import xget.mc.mypartner.viewmodel.screens.Level1Navigation
import xget.mc.mypartner.viewmodel.screens.Screen
import xget.mc.mypartner.viewmodel.states.ScreenParams

@Composable
fun Navigation.Router() {

    val screenUIsStateHolder = rememberSaveableStateHolder()
    val localNavigationState = remember { mutableStateOf( navigationState ) }

    val twopaneWidthThreshold = 1000.dp
    BoxWithConstraints {
        OnePane(screenUIsStateHolder, localNavigationState)
    }

    HandleBackButton(screenUIsStateHolder, localNavigationState)

}

fun Navigation.navigationProcessor(localNavigationState: MutableState<NavigationState>) : (Screen, ScreenParams?) -> Unit {
    return { screen, screenParams ->
        val screenIdentifier = ScreenIdentifier.get(screen, screenParams)
        navigateToScreen(screenIdentifier) // shared navigationState is updated
        localNavigationState.value = navigationState // update localNavigationState
    }
}

fun Navigation.level1NavigationProcessor(localNavigationState: MutableState<NavigationState>) : (Level1Navigation) -> Unit {
    return {
        selectLevel1Navigation(it.screenIdentifier) // shared navigationState is updated
        localNavigationState.value = navigationState // update localNavigationState
    }
}