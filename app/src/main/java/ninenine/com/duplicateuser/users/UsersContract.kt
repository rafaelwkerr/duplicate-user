package ninenine.com.duplicateuser.users

import ninenine.com.duplicateuser.base.BasePresenter
import ninenine.com.duplicateuser.base.BaseView
import ninenine.com.duplicateuser.domain.User

interface UsersContract {

    interface View : BaseView<Presenter> {
        fun showUsers(users: Set<User>)
    }

    interface Presenter : BasePresenter {
        fun loadUsers()
    }

}