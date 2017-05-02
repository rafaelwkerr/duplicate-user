package ninenine.com.duplicateuser.repository.local

import android.content.Context
import com.squareup.moshi.Moshi
import io.reactivex.Flowable
import io.reactivex.Flowable.fromIterable
import ninenine.com.duplicateuser.domain.User
import ninenine.com.duplicateuser.functions.loadJSONFromAsset
import ninenine.com.duplicateuser.repository.UserRepository
import javax.inject.Inject

class LocalUserRepository @Inject constructor(private val context: Context,
                                                  private val moshi: Moshi) : UserRepository {

    override fun getUsersWithSet(): Set<User> =
            HashSet<User>(convertJsonStringToUsers()?.toMutableList())


    override fun getUsersWithList(): MutableList<User>? =
            convertJsonStringToUsers()?.distinct()?.toMutableList()

    private fun convertJsonStringToUsers(): Array<User>? {
        val usersFromJsonFile = loadJSONFromAsset(context)
        val jsonAdapter = moshi.adapter<Array<User>>(Array<User>::class.java)
        var users: Array<User>? = null
        try {
            users = jsonAdapter.fromJson(usersFromJsonFile)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return users
    }
}