package ninenine.com.duplicateuser.functions

import android.content.Context
import android.support.annotation.IdRes
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import org.joda.time.DateTime
import java.io.IOException

fun AppCompatActivity.setupActionBar(@IdRes toolbarId: Int, action: ActionBar.() -> Unit) {
    setSupportActionBar(findViewById(toolbarId) as Toolbar?)
    supportActionBar?.run {
        action()
    }
}

fun convertDateISO8601(dateISO: String): String = DateTime(dateISO).toLocalDate().toString()

fun loadJSONFromAsset(context: Context): String {
    val json: String?
    try {
        val inputStream = context.assets.open("users.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        json = String(buffer)
    } catch (ex: IOException) {
        ex.printStackTrace()
        return ""
    }
    return json
}
