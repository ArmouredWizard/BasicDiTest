package uk.co.maddwarf.basicditest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import uk.co.maddwarf.basicditest.home.HomeDestination
import uk.co.maddwarf.basicditest.home.HomeScreen
import uk.co.maddwarf.basicditest.ui.screens.NewScreen
import uk.co.maddwarf.basicditest.ui.screens.NewScreenDestination

@Composable
fun BasicDiTestNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
    ) {

        fun navigateToHome() = navController.navigate(HomeDestination.route)


        composable(route = HomeDestination.route) {
            HomeScreen(
                modifier = Modifier,
                     navigateToNewScreen = { navController.navigate("${NewScreenDestination.route}/${it}") },
                //     navigateToSettings = {},//todo add Settings destination

            )
        }//end Home composable

        composable(route = NewScreenDestination.routeWithArgs,
            arguments = listOf(
                navArgument(NewScreenDestination.itemIdArg) {
                    type = NavType.StringType
                }
            )
        ) {
            NewScreen(
                navigateToHome = { navigateToHome() }
            )
        }



    }
}