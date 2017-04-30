package ninenine.com.duplicateuser.users

import ninenine.com.duplicateuser.repository.UserRepository


class UserPresenter constructor(val userRepository: UserRepository,
                                val usersView: UsersContract.View) : UsersContract.Presenter {

    init { usersView.presenter = this }

    override fun start() { loadUsers() }

    override fun loadUsers() {
        val usersSet = userRepository.getUsersWithSet()
        usersView.showUsers(usersSet)
    }
}