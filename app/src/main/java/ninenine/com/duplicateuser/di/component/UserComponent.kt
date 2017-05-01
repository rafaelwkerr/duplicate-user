package ninenine.com.duplicateuser.di.component

import dagger.Subcomponent
import ninenine.com.duplicateuser.di.modules.UserModule
import ninenine.com.duplicateuser.ui.UsersActivity
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity: UsersActivity)
}