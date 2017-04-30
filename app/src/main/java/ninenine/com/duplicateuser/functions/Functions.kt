package ninenine.com.duplicateuser.functions

import android.content.Context
import java.io.IOException


fun loadJSONFromAsset(context: Context): String {
    var json: String? = null
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