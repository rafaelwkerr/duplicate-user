package ninenine.com.duplicateuser.presenter

import android.util.Log
import io.reactivex.Flowable
import io.reactivex.rxkotlin.toFlowable
import ninenine.com.duplicateuser.functions.convertDateISO8601
import ninenine.com.duplicateuser.repository.UserRepository
import ninenine.com.duplicateuser.view.UserContractView
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
        val userSetObservable = userRepository.getUsersWithSet()?.toFlowable()

        userSetObservable?.let { it
                    .flatMap {
                        it.birthday = convertDateISO8601(it.birthday)
                        Flowable.just(it)
                    }
                    .toList()
                    .subscribe(
                            {userContractView?.showUsers(it)},
                            {Log.e(TAG, "error=" + it)}
                    )
        }
    }
}