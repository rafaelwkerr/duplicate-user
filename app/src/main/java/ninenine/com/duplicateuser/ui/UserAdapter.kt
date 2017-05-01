package ninenine.com.duplicateuser.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_content_view.view.*
import ninenine.com.duplicateuser.R
import ninenine.com.duplicateuser.domain.User


class UserAdapter(var users: MutableList<User>) : RecyclerView.Adapter<UsersHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UsersHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_content_view,
                parent, false)
        return UsersHolder(view)
    }

    override fun onBindViewHolder(holder: UsersHolder?, position: Int) {
        holder?.bind(users[position])
    }

    override fun getItemCount() = users.size
}

class UsersHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    fun bind(user: User) {
        with(user){
            itemView.user_name.text = user.name
            itemView.user_birthday.text = user.birthday
        }
    }
}
