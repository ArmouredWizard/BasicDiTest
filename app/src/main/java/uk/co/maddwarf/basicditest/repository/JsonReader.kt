package uk.co.maddwarf.basicditest.repository

import android.content.Context
import android.util.Log
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import dagger.hilt.android.qualifiers.ApplicationContext
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import uk.co.maddwarf.basicditest.model.Monster
import java.io.BufferedReader

interface JsonReader {
    fun readAsset(file: String): String
    fun getCategoriesList(table: String): List<String>
    fun getListFromCategory(file: String, category: String): List<String>
}

class JsonReaderImpl(@ApplicationContext val context: Context) : JsonReader {//end jsonReader

    override fun readAsset(file: String): String {
        val string = context
            .assets
            .open(file)
            .bufferedReader()
            .use(BufferedReader::readText)

        return string
    }//end readAsset

    override fun getCategoriesList(table: String): List<String> {
        val theJsonString: String =
            readAsset(file = "$table.json")
        val theJsonObject: JsonObject =
            JsonParser.parseString(theJsonString).asJsonObject!!

        val categories = mutableListOf<String>()
        val theNames = theJsonObject.keySet()

        for (element in theNames) {
            categories.add(element)
        }
        return categories.sorted()
    }//end getCategoriesList

    override fun getListFromCategory(file: String, category: String): List<String> {
        val theJsonString:String = readAsset("$file.json")
        //todo get list of monsters in chson category

        val list: MutableList<String> = mutableListOf()
        val tableArray: JSONArray
        val thisJSON = JSONObject(readAsset("$file.json"))

        try {
            tableArray = thisJSON.getJSONArray(category)

            for (i in 0 until tableArray.length()) {
                val c = tableArray.getJSONObject(i)
                val name = c.getString("name")
                list.add(name)
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

}