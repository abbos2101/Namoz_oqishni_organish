package abbos2101.namozoqishniorganish

import abbos2101.mvvmdemo.common.fromJsonObject
import abbos2101.namozoqishniorganish.module.AssetsProvider
import abbos2101.namozoqishniorganish.module.JsonModel
import android.app.Application
import android.content.Context

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        val json = AssetsProvider.instance().getJsonDataFromAsset()
        if (json != null)
            model = json.fromJsonObject(JsonModel::class.java)
    }

    companion object {
        lateinit var context: Context
        lateinit var model: JsonModel
    }
}