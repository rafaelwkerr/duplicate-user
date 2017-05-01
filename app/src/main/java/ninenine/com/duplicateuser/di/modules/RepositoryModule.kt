package ninenine.com.duplicateuser.di.modules

import dagger.Module
import dagger.Provides
import ninenine.com.duplicateuser.repository.UserRepository
import ninenine.com.duplicateuser.repository.local.LocalUserRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(localUserRepository: LocalUserRepository): UserRepository =
            localUserRepository

}