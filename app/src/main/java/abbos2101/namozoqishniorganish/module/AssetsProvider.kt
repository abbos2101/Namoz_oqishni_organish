package abbos2101.namozoqishniorganish.module

import abbos2101.namozoqishniorganish.App
import android.content.Context
import java.io.IOException

class AssetsProvider {
    fun getJsonDataFromAsset(
        context: Context = App.context,
        fileName: String = "contents.json"
    ): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    companion object {
        private var instance: AssetsProvider? = null
        fun instance(): AssetsProvider {
            if (instance == null)
                instance = AssetsProvider()
            return instance!!
        }
    }
}