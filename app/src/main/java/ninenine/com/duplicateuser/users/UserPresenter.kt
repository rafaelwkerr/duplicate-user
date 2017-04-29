package ninenine.com.duplicateuser.users

import io.reactivex.schedulers.Schedulers
import ninenine.com.duplicateuser.repository.UserRepository


class UserPresenter constructor(val userRepository: UserRepository,
                                val usersView: UsersContract.View) : UsersContract.Presenter {

    init {
        usersView.presenter = this
    }


    override fun start() {

    }

    override fun loadUsers() {

        val users = userRepository.getUsersWithList()


        users.let { it
                .subscribeOn(Schedulers.io())
                .distinct()
                .subscribe {
                    usersView.showUsers(it)
                }
        }
    }

    override fun handleError(throwable: Throwable) {

    }

}