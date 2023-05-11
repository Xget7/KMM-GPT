package xget.mc.composables.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.saveable.SaveableStateHolder
import xget.mc.mypartner.viewmodel.Navigation
import xget.mc.mypartner.viewmodel.NavigationState

@Composable
fun Navigation.HandleBackButton(
    saveableStateHolder: SaveableStateHolder,
    localNavigationState: MutableState<NavigationState>
) {
}