package uk.co.maddwarf.basicditest.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uk.co.maddwarf.basicditest.domain.MonsterUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val monsterUseCase: MonsterUseCase): ViewModel() {

    fun inhabitantsList(): List<String> = monsterUseCase.getListOfMonsters()

}
