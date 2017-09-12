package ninenine.com.duplicateuser.repository.local

import android.content.Context
import android.util.Log
import com.squareup.moshi.Moshi
import ninenine.com.duplicateuser.domain.User
import ninenine.com.duplicateuser.functions.loadJSONFromAsset
import ninenine.com.duplicateuser.repository.UserRepository
import javax.inject.Inject

class LocalUserRepository @Inject constructor(private val context: Context,
                                                  private val moshi: Moshi) : UserRepository {

    private val TAG = LocalUserRepository::class.java.simpleName

    override fun getUsersWithSet(): Set<User>? =
            convertJsonStringToUsers()?.toSet()

    override fun getUsersWithList(): List<User>? =
            convertJsonStringToUsers()?.distinct()


    fun convertJsonStringToUsers(): Array<User>? {
        val usersFromJsonFile = loadJSONFromAsset(context)
        val jsonAdapter = moshi.adapter<Array<User>>(Array<User>::class.java)
        var users: Array<User>? = null
        try {
            users = jsonAdapter.fromJson(usersFromJsonFile)
        } catch (e: Exception) {
            Log.e(TAG, "error=" + e)
        }
        return users
    }
}