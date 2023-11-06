package uk.co.maddwarf.basicditest.repository

import javax.inject.Inject

interface MonsterRepository {
    fun getListOfMonsters(): List<String>
}

class MonsterRepositoryImpl @Inject constructor(val jsonReader: JsonReader) :
    MonsterRepository {
    override fun getListOfMonsters(): List<String> {

        val list = jsonReader.getCategoriesList("file")
        return list

    }

}
