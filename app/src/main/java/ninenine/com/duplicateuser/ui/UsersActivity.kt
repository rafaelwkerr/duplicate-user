package ninenine.com.duplicateuser.ui

import android.content.Context
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import ninenine.com.duplicateuser.R
import ninenine.com.duplicateuser.di.modules.UserModule
import ninenine.com.duplicateuser.domain.User
import ninenine.com.duplicateuser.extensions.app
import ninenine.com.duplicateuser.functions.setupActionBar
import ninenine.com.duplicateuser.presenter.UserPresenterImpl
import ninenine.com.duplicateuser.view.UserContractView
import javax.inject.Inject

class UsersActivity : AppCompatActivity(), UserContractView, NavigationView.OnNavigationItemSelectedListener {

    @Inject lateinit var usersPresenter: UserPresenterImpl

    private lateinit var drawerLayout: DrawerLayout
    private var userAdapter: UserAdapter? = null

    private val component by lazy { app.component.plus(UserModule(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)

        setupActionBar(R.id.toolbar) {
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayHomeAsUpEnabled(true)
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout

        with(drawer){
            val toggle = ActionBarDrawerToggle(
                    this@UsersActivity, this, toolbar, R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close)
            addDrawerListener(toggle)
            toggle.syncState()
        }

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

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


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_exit_app -> finish()
        }
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun getContext(): Context { return this }

}
