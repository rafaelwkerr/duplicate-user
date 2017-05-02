package ninenine.com.duplicateuser

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import ninenine.com.duplicateuser.di.component.AppComponent
import ninenine.com.duplicateuser.di.component.DaggerAppComponent
import ninenine.com.duplicateuser.di.modules.AppModule
import android.graphics.Bitmap
import com.facebook.imagepipeline.core.ImagePipelineConfig
import net.danlew.android.joda.JodaTimeAndroid


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
        val config = ImagePipelineConfig.newBuilder(this)
                .setBitmapsConfig(Bitmap.Config.RGB_565)
                .setDownsampleEnabled(true)
                .build()
        Fresco.initialize(this, config)
        JodaTimeAndroid.init(this)
    }

}