package uk.co.maddwarf.basicditest.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import uk.co.maddwarf.basicditest.R
import uk.co.maddwarf.basicditest.navigation.NavigationDestination

object NewScreenDestination : NavigationDestination {
    override val route = "new_screen"
    override val titleRes = R.string.new_screen_title

    const val itemIdArg = "new_data"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@Composable
fun NewScreen(
    navigateToHome: () -> Unit,
    newViewModel: NewViewModel = hiltViewModel()
) {

    //variables and functions here
    val data = newViewModel.incomingData

    NewBody(
        navigateToHome = navigateToHome,
        data = data
    )

}

@Composable
fun NewBody(
    navigateToHome: () -> Unit,
    data: String
) {
    Text(text = data)

}
