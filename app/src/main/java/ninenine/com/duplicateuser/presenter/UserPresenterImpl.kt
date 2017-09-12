package ninenine.com.duplicateuser.presenter

import android.util.Log
import ninenine.com.duplicateuser.functions.convertDateISO8601
import ninenine.com.duplicateuser.repository.UserRepository
import ninenine.com.duplicateuser.view.UserContractView
import rx.Observable
import rx.lang.kotlin.toObservable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPresenterImpl @Inject constructor(private val userRepository: UserRepository) : UserPresenter {

    private val TAG = UserPresenterImpl::class.java.simpleName

    var userContractView: UserContractView? = null

    override fun attachView(view: UserContractView) {
        view.let {
            userContractView=view
        }
    }

    override fun loadUsers() {
        val userSetObservable = userRepository.getUsersWithSet()?.toObservable()

        userSetObservable?.let { it
                    .flatMap {
                        it.birthday = convertDateISO8601(it.birthday)
                        Observable.just(it)
                    }
                    .toList()
                    .subscribe(
                            {userContractView?.showUsers(it)},
                            {Log.e(TAG, "error=" + it)}
                    )
        }
    }
}