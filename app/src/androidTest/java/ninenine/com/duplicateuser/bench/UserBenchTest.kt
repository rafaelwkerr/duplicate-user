package ninenine.com.duplicateuser.bench

import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.squareup.moshi.Moshi
import ninenine.com.duplicateuser.repository.UserRepository
import ninenine.com.duplicateuser.repository.local.LocalUserRepository
import ninenine.com.duplicateuser.ui.UsersActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.system.measureNanoTime


@RunWith(AndroidJUnit4::class) @SmallTest class UserBenchTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(UsersActivity::class.java)

    @Test
    fun bench_getAllUsers_usingSet(){
        val userRepository: UserRepository
        val moshi = Moshi.Builder().build()
        userRepository = LocalUserRepository(mActivityTestRule.activity, moshi)

        val timeElapsed = measureNanoTime {
            userRepository.getUsersWithSet()
        }
        println("BenchTest_Set: $timeElapsed")
    }

    @Test
    fun bench_getAllUsers_usingListDistinct(){
        val userRepository: UserRepository
        val moshi = Moshi.Builder().build()
        userRepository = LocalUserRepository(mActivityTestRule.activity, moshi)

        val timeElapsed = measureNanoTime {
            userRepository.getUsersWithList()
        }
        println("BenchTest_Distinct: $timeElapsed")
    }


}