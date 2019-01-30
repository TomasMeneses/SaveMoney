package com.example.tomas.savemoney.Adapter

import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tomas.savemoney.R

import com.example.tomas.savemoney.Users
import kotlinx.android.synthetic.main.recy_layout.view.*

class MyAdapter(private val umusuario: List<Users>, private val context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>()  {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario = umusuario[position]
        holder?.let {
            it.bindView(usuario)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recy_layout, parent, false)
        return ViewHolder(view)
    }

    override  fun getItemCount(): Int {
        return umusuario.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(note: Users) {
            val email = itemView.userEmailView
            val id = itemView.userId


            email.text = note.email
            id.text = note.id

        }

    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener(){
                //                val Detalhes = Intent(itemView.context, TelaUser::class.java)
//                itemView.context.startActivity(Detalhes)

            }
        }

    }

}













































//(private var context: Context): RecyclerView.Adapter<MyViewHolder>() {
//
//    internal var userList: MutableList<Users>
//
//    val lastItemId:String?
//    get() = userList[userList.size - 1].id
//
//    fun addAll(newUsers:List<Users>){
//        val init = userList.size
//        userList.addAll(newUsers)
//        notifyItemRangeChanged(init, newUsers.size)
//    }
//
//    fun removeLastItem(){
//        userList.removeAt(userList.size - 1)
//    }
//
//    init {
//        this.userList = ArrayList()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
//
//        val itemView = LayoutInflater.from(context).inflate(R.layout.recy_layout, parent, false)
//        return MyViewHolder(itemView)
//    }
//
//    override fun getItemCount(): Int {
//
//        return userList.size
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//
//        holder.txt_email.text = userList[position].email
//        holder.txt_id.text = userList[position].id
//
//    }
//}
//
//class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//     internal var txt_email: TextView
//     internal var txt_id: TextView
//
//        init {
//            txt_email = itemView.findViewById<TextView>(R.id.userEmailView)
//            txt_id = itemView.findViewById<TextView>(R.id.userId)
//        }
//
//}
