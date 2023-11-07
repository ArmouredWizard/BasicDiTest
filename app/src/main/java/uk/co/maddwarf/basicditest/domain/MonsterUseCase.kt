package uk.co.maddwarf.basicditest.domain

import uk.co.maddwarf.basicditest.model.Monster
import uk.co.maddwarf.basicditest.repository.MonsterRepository
import javax.inject.Inject

class MonsterUseCase @Inject constructor(private val monsterRepository: MonsterRepository) {
    fun getListOfCategories(): List<String> {
        return monsterRepository.getListOfMonsters()
    }

    fun getListOfItems(category:String): List<String> {
        return monsterRepository.getListOfItems(file = "file", category = category)
    }

}
