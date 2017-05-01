package ninenine.com.duplicateuser.ui

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_main.*
import ninenine.com.duplicateuser.DuplicateUserApplication
import ninenine.com.duplicateuser.R
import ninenine.com.duplicateuser.di.modules.UserModule
import ninenine.com.duplicateuser.domain.User
import ninenine.com.duplicateuser.extensions.app
import ninenine.com.duplicateuser.functions.setupActionBar
import ninenine.com.duplicateuser.presenter.UserPresenterImpl
import ninenine.com.duplicateuser.view.UserContractView
import javax.inject.Inject

class UsersActivity : AppCompatActivity(), UserContractView {

    val TAG = UsersActivity::class.java.name

    @Inject lateinit var usersPresenter: UserPresenterImpl

    private var userAdapter: UserAdapter? = null
    private val users: MutableList<User>? = mutableListOf()

    val component by lazy { app.component.plus(UserModule(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //DuplicateUserApplication.appComponent.inject(this)
        component.inject(this)

        setupActionBar(R.id.toolbar) {
            setDisplayHomeAsUpEnabled(true)
        }

        usersPresenter.attachView(this)
        setupRecycler()

    }

    private fun setupRecycler() {
        val layoutManager = LinearLayoutManager(this)
        recycler_view_layour_recycler?.layoutManager = layoutManager
        recycler_view_layour_recycler?.addItemDecoration(
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    override fun showUsers(users: Collection<User>) {
        users?.let {
            userAdapter = UserAdapter(users.toMutableList())
            recycler_view_layour_recycler?.adapter= userAdapter
        }
    }

    override fun getContext(): Context { return this }

}
