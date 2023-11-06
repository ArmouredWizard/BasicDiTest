package uk.co.maddwarf.basicditest

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uk.co.maddwarf.basicditest.navigation.BasicDiTestNavHost

@Composable
fun BasicDiTestApp(
    navController: NavHostController = rememberNavController()
) {
    BasicDiTestNavHost(navController = navController)
}

//define TopAppBar here