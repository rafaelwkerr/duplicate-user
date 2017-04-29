package ninenine.com.duplicateuser.repository

import io.reactivex.Flowable
import ninenine.com.duplicateuser.domain.User

interface UserRepository {
    fun getUsersWithSet(): Flowable<Set<User>>
    fun getUsersWithList(): Flowable<List<User>>
}