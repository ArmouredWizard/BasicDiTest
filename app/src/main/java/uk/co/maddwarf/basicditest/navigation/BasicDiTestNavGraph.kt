package uk.co.maddwarf.basicditest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uk.co.maddwarf.basicditest.home.HomeDestination
import uk.co.maddwarf.basicditest.home.HomeScreen

@Composable
fun BasicDiTestNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                modifier = Modifier,
                //     navigateToMapScreen = { navController.navigate("${MapScreenDestination.route}/${it}") },
                //     navigateToSettings = {},//todo add Settings destination

            )
        }//end Home composable
    }
}