package uk.co.maddwarf.basicditest.domain

import uk.co.maddwarf.basicditest.repository.MonsterRepository
import javax.inject.Inject

class MonsterUseCase @Inject constructor(val monsterRepository: MonsterRepository) {
    fun getListOfMonsters(): List<String> {
        return monsterRepository.getListOfMonsters()
    }


}
