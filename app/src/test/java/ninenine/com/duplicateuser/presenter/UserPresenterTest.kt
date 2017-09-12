package ninenine.com.duplicateuser.presenter

import ninenine.com.duplicateuser.domain.User
import ninenine.com.duplicateuser.initMocks
import ninenine.com.duplicateuser.repository.UserRepository
import ninenine.com.duplicateuser.view.UserContractView
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.*
import java.util.*


class UserPresenterTest {

    @Mock private lateinit var userRepository: UserRepository

    @Mock private lateinit var userContractView: UserContractView

    private lateinit var userPresenter: UserPresenter

    private var users: MutableList<User> = mutableListOf()


    @Before
    fun setupUserPresenter() {
        initMocks(this)

        userPresenter = UserPresenterImpl(userRepository)
        userPresenter.attachView(userContractView)

        val userSteve = User(UUID.randomUUID().toString(), "Steve Jobs",
                "http://adsoftheworld.com/files/steve-jobs.jpg", "1955-02-24T00:00:00Z",
                "Steven Paul Jobs was an American businessman, inventor")

        val userCraig = User(UUID.randomUUID().toString(), "Craig Federighi",
                "http://adsoftheworld.com/files/steve-jobs.jpg", "1969-05-27T00:00:00Z",
                "Craig Federighi is Apple's senior vice president")

        users.add(userSteve)
        users.add(userCraig)

    }

    @Test
    fun loadAllUsersFromRepository() {
        doReturn(users.toSet())
                .`when`(userRepository)
                .getUsersWithSet()

        with(userPresenter) { loadUsers() }
        verify(userContractView, times(1)).showUsers(users)
        Assert.assertTrue(users.size == 2)
    }

}