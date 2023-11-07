package uk.co.maddwarf.basicditest.ui.screens

import androidx.compose.ui.geometry.Offset
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import uk.co.maddwarf.basicditest.domain.MonsterUseCase
import uk.co.maddwarf.basicditest.model.Monster
import javax.inject.Inject

@HiltViewModel
class NewViewModel @Inject constructor(
    val monsterUseCase: MonsterUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    var incomingData: String =
        checkNotNull(savedStateHandle[NewScreenDestination.itemIdArg])

    fun dataList():List<String> = monsterUseCase.getListOfItems(incomingData)

    private var _uiState = MutableStateFlow(
        NewUiState(
           list = dataList()
        )
    )

    val uiState: StateFlow<NewUiState> = _uiState.asStateFlow()

    fun updateUiState(list:List<String>) {
        _uiState.value = NewUiState(
            list = list
        )
    }

}//end View Model

data class NewUiState(
    val list: List<String>,
)