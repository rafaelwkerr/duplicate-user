package ninenine.com.duplicateuser.view

import ninenine.com.duplicateuser.domain.User


interface UserContractView: IView {
    fun showUsers(users: Collection<User>)
}