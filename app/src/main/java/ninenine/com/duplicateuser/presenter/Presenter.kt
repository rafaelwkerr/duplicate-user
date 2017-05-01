package ninenine.com.duplicateuser.presenter

interface Presenter<in T> {
    fun attachView(view: T)
}