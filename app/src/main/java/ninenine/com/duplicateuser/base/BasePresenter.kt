package ninenine.com.duplicateuser.base

interface BasePresenter<in T> {
    fun attachView(view: T)
}