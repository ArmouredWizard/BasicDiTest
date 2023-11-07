package uk.co.maddwarf.basicditest.repository

import uk.co.maddwarf.basicditest.model.Monster
import javax.inject.Inject

interface MonsterRepository {
    fun getListOfMonsters(): List<String>
    fun getListOfItems(file: String, category: String): List<String>
}

class MonsterRepositoryImpl @Inject constructor(private val jsonReader: JsonReader) :
    MonsterRepository {
    override fun getListOfMonsters(): List<String> {
        val list = jsonReader.getCategoriesList("file")
        return list
    }

    override fun getListOfItems(file: String, category: String): List<String> {
        val list = jsonReader.getListFromCategory(file = file, category = category)
        return list
   }

}
