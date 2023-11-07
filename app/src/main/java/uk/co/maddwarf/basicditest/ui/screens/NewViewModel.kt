package uk.co.maddwarf.basicditest.ui.screens

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(){

    var incomingData: String =
        checkNotNull(savedStateHandle[NewScreenDestination.itemIdArg])



}