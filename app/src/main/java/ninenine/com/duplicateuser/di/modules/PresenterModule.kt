package ninenine.com.duplicateuser.di.modules

import dagger.Module
import dagger.Provides
import ninenine.com.duplicateuser.presenter.UserPresenter
import ninenine.com.duplicateuser.presenter.UserPresenterImpl
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideUserPresenter(userPresenter: UserPresenterImpl): UserPresenter = userPresenter


}