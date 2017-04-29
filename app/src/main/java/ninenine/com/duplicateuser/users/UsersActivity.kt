package ninenine.com.duplicateuser.users

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ninenine.com.duplicateuser.R

class UsersActivity : AppCompatActivity() {

    private lateinit var usersPresenter: UserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
