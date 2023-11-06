package uk.co.maddwarf.basicditest.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import uk.co.maddwarf.basicditest.composables.MySpinner
import uk.co.maddwarf.basicditest.navigation.NavigationDestination
import uk.co.maddwarf.basicditest.R

object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.app_name
}

@Composable
fun HomeScreen(
    modifier: Modifier,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val inhabitantsList = homeViewModel.inhabitantsList()
    Log.d("HOME", "LOADED")

    Scaffold(
        modifier = modifier

        /*   floatingActionButton = {
               FloatingActionButton(
                   onClick = navigateToSettings,
                   shape = MaterialTheme.shapes.medium,
                   modifier = Modifier.padding(16.dp)
               ) {
                   Icon(
                       imageVector = Icons.Default.Settings,
                       contentDescription = "Settings Icon"
                   )
               }
           }*/
    ) { innerPadding ->
        HomeBody(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            inhabitantsList = inhabitantsList
        )
    }//end Scaffold

}//end HomeScreen

@Composable
fun HomeBody(
    modifier: Modifier,
    inhabitantsList: List<String>
) {
    Log.d("HOME BODY", "Loaded")

    var inhabitantsExpanded by remember { mutableStateOf(false) }
    var chosenInhabitants by remember { mutableStateOf(inhabitantsList[0]) }
    fun inhabitantsChooser(inhabitants: String) {
        inhabitantsExpanded = false
        chosenInhabitants = inhabitants
    }

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(text = "Inhabitants: ")
            MySpinner(
                expanded = inhabitantsExpanded,
                onClick = { inhabitantsExpanded = !inhabitantsExpanded },
                list = inhabitantsList,
                chooser = ::inhabitantsChooser,
                report = chosenInhabitants
            )

        }//end outer row

    }//end Box
}
