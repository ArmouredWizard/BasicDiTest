package uk.co.maddwarf.basicditest.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uk.co.maddwarf.basicditest.domain.MonsterUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val monsterUseCase: MonsterUseCase): ViewModel() {

    fun categoriesList(): List<String> = monsterUseCase.getListOfCategories()

}
