package ninenine.com.duplicateuser

import android.app.Application
import ninenine.com.duplicateuser.di.component.AppComponent
import ninenine.com.duplicateuser.di.component.DaggerAppComponent
import ninenine.com.duplicateuser.di.modules.AppModule

class DuplicateUserApplication : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

}