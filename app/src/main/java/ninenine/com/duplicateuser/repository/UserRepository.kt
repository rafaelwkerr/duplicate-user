package ninenine.com.duplicateuser.repository

import ninenine.com.duplicateuser.domain.User

interface UserRepository {
    fun getUsersWithSet(): Set<User>
    fun getUsersWithList(): MutableList<User>?
}