package ninenine.com.duplicateuser.ui


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.MediumTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import ninenine.com.duplicateuser.R
import ninenine.com.duplicateuser.RecyclerViewMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class) @MediumTest class UsersActivityTest {

    @Rule @JvmField
    var mActivityTestRule = ActivityTestRule(UsersActivity::class.java)

    @Test
    fun usersActivityTest_validateNameIsDisplayed() {
        onView(withRecyclerView(R.id.recycler_view_layour_recycler)
                .atPositionOnView(0, R.id.user_name))
                .check(matches(isDisplayed()))
    }

    @Test
    fun usersActivityTest_validateBirthdayIsDisplayed() {
        onView(withRecyclerView(R.id.recycler_view_layour_recycler)
                .atPositionOnView(0, R.id.user_birthday))
                .check(matches(isDisplayed()))
    }

    @Test
    fun usersActivityTest_validatePhotoIsDisplayed() {
        onView(withRecyclerView(R.id.recycler_view_layour_recycler)
                .atPositionOnView(0, R.id.user_photo))
                .check(matches(isDisplayed()))
    }

    @Test
    fun usersActivityTest_validateBioIsDisplayed() {
        onView(withRecyclerView(R.id.recycler_view_layour_recycler)
                .atPositionOnView(0, R.id.user_bio))
                .check(matches(isDisplayed()))
    }

    @Test
    fun userActivityTest_validateAppName() {
        onView(withId(R.id.toolbar))
                .check(matches(isDisplayed()))
    }

    companion object {
        fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
            return RecyclerViewMatcher(recyclerViewId)
        }
    }
}
