package ninenine.com.duplicateuser.di.component

import dagger.Component
import ninenine.com.duplicateuser.DuplicateUserApplication
import ninenine.com.duplicateuser.di.modules.AppModule
import ninenine.com.duplicateuser.di.modules.PresenterModule
import ninenine.com.duplicateuser.di.modules.RepositoryModule
import ninenine.com.duplicateuser.di.modules.UserModule
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AppModule::class, RepositoryModule::class, PresenterModule::class))
interface AppComponent {
    fun inject(duplicateUserApplication: DuplicateUserApplication)
    fun plus(homeModule: UserModule): UserComponent
}