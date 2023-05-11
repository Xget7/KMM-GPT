package xget.mc.mypartner.android.composables.navigation.templates

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.saveable.SaveableStateHolder
import xget.mc.mypartner.android.composables.navigation.ScreenPicker
import xget.mc.mypartner.android.composables.navigation.bars.Level1BottomBar
import xget.mc.mypartner.android.composables.navigation.bars.TopBar
import xget.mc.composables.navigation.level1NavigationProcessor
import xget.mc.composables.navigation.navigationProcessor
import xget.mc.mypartner.viewmodel.Navigation
import xget.mc.mypartner.viewmodel.NavigationState

@Composable
fun Navigation.OnePane(
    saveableStateHolder: SaveableStateHolder,
    localNavigationState: MutableState<NavigationState>
) {
    val screenIdentifier = localNavigationState.value.topScreenIdentifier
    val title = getTitle(screenIdentifier)
    Scaffold(
        topBar = {  },
        content = {it
            saveableStateHolder.SaveableStateProvider(screenIdentifier.URI) {
                ScreenPicker(screenIdentifier, navigationProcessor(localNavigationState))
            }
        },
        bottomBar = { if (screenIdentifier.screen.navigationLevel == 1) Level1BottomBar(screenIdentifier, level1NavigationProcessor(localNavigationState)) }
    )
}