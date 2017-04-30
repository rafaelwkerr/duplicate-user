package ninenine.com.duplicateuser.users

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_main.*
import ninenine.com.duplicateuser.R
import ninenine.com.duplicateuser.domain.User
import ninenine.com.duplicateuser.functions.setupActionBar

class UsersActivity : AppCompatActivity(), UsersContract.View {

    override lateinit var presenter: UsersContract.Presenter

    private var userAdapter: UserAdapter? = null
    private val users: MutableList<User>? = mutableListOf()

    private lateinit var usersPresenter: UserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBar(R.id.toolbar) {
            setDisplayHomeAsUpEnabled(true)
        }

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
}
