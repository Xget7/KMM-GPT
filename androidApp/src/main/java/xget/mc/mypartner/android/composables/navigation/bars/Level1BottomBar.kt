package xget.mc.mypartner.android.composables.navigation.bars

import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import xget.mc.mypartner.viewmodel.Navigation
import xget.mc.mypartner.viewmodel.ScreenIdentifier
import xget.mc.mypartner.viewmodel.screens.Level1Navigation


// this is the bottom horizontal navigation bar for 1-Pane visualization
// (used by small devices and in Portrait mode)

@Composable
fun Navigation.Level1BottomBar(
    selectedTab: ScreenIdentifier,
    navigateByLevel1Menu: (Level1Navigation) -> Unit
) {
//    BottomAppBar(content = {
//        BottomNavigationItem(
//            icon = { Icon(Icons.Default.Menu, "ALL") },
//            label = { Text("All Countries", fontSize = 13.sp) },
//            selected = selectedTab.URI == Level1Navigation.ChatScreen.screenIdentifier.URI,
//            onClick = { navigateByLevel1Menu(Level1Navigation.ChatScreen) }
//        )
//    })
}