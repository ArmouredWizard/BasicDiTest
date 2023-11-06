package uk.co.maddwarf.basicditest.repository

import android.content.Context
import android.util.Log
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.BufferedReader

interface JsonReader {
    fun readAsset(file: String): String
    fun getCategoriesList(table: String): List<String>
}

class JsonReaderImpl(@ApplicationContext val context: Context) : JsonReader {

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

}//end jsonReader