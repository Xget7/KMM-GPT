package xget.mc.mypartner.android.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import xget.mc.composables.navigation.Router
import xget.mc.mypartner.viewmodel.MyParterViewModel


@Composable
fun MainComposable(model: MyParterViewModel) {
    val appState by model.stateFlow.collectAsState()
    println("APP RECOMPOSITION: index #"+appState.recompositionIndex.toString())
    val partnerNav = appState.getNavigation(model)
    partnerNav.Router()
}
