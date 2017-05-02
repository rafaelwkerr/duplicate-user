package ninenine.com.duplicateuser.presenter

import ninenine.com.duplicateuser.repository.UserRepository
import ninenine.com.duplicateuser.view.UserContractView
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPresenterImpl @Inject constructor(private val userRepository: UserRepository) : UserPresenter {

    val TAG = UserPresenterImpl::class.java.simpleName

    private var userContractView: UserContractView? = null

    override fun attachView(view: UserContractView) {
        view.let {
            userContractView=view
            loadUsers()
        }
    }

    private fun loadUsers() {
        val usersSet = userRepository.getUsersWithSet()
        val usersList = userRepository.getUsersWithList()
        usersList?.let { userContractView?.showUsers(it) }
    }

}