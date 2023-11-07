package uk.co.maddwarf.basicditest.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val uiState by newViewModel.uiState.collectAsState()

    //variables and functions here
    val data = newViewModel.incomingData
    //val dataList = newViewModel.dataList()
    val dataList = uiState.list

    NewBody(
        navigateToHome = navigateToHome,
        data = data,
        dataList = dataList
    )

}//end New Screen

@Composable
fun NewBody(
    navigateToHome: () -> Unit,
    data: String,
    dataList:List<String>
) {
    Column {
        Text(text = data, style = TextStyle(textDecoration = TextDecoration.Underline))
        dataList.forEach {
            Text(text = it)
        }
    }

}//end New Body
