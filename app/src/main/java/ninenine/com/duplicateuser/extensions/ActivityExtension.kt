package ninenine.com.duplicateuser.extensions

import android.app.Activity
import ninenine.com.duplicateuser.DuplicateUserApplication

val Activity.app: DuplicateUserApplication
    get() = application as DuplicateUserApplication