package ninenine.com.duplicateuser.di.modules


import android.content.Context
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import ninenine.com.duplicateuser.DuplicateUserApplication
import javax.inject.Singleton

@Module
class AppModule(val application: DuplicateUserApplication) {

    @Provides @Singleton fun provideApp() = application

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application


    @Provides
    @Singleton
    fun provideMoshiBuilder(): Moshi = Moshi.Builder().build()

}