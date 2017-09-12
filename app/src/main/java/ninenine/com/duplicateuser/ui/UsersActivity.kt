package ninenine.com.duplicateuser.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_main.*
import ninenine.com.duplicateuser.R
import ninenine.com.duplicateuser.di.modules.UserModule
import ninenine.com.duplicateuser.domain.User
import ninenine.com.duplicateuser.extensions.app
import ninenine.com.duplicateuser.functions.setupActionBar
import ninenine.com.duplicateuser.presenter.UserPresenterImpl
import ninenine.com.duplicateuser.view.UserContractView
import javax.inject.Inject

class UsersActivity : AppCompatActivity(), UserContractView {

    @Inject lateinit var usersPresenter: UserPresenterImpl

    private var userAdapter: UserAdapter? = null

    private val component by lazy { app.component.plus(UserModule(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)

        setupActionBar(R.id.toolbar) {
            setDisplayHomeAsUpEnabled(true)
        }

        usersPresenter.attachView(this)
        usersPresenter.loadUsers()
        setupRecycler()

    }

    private fun setupRecycler() {
        val layoutManager = LinearLayoutManager(this)
        recycler_view_layour_recycler?.layoutManager = layoutManager
        recycler_view_layour_recycler?.adapter= userAdapter
    }

    override fun showUsers(users: Collection<User>) {
        users.let { userAdapter = UserAdapter(users.toMutableList()) }
    }

    override fun getContext(): Context { return this }

}
