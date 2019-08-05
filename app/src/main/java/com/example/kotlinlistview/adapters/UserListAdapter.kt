package com.example.kotlinlistview.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kotlinlistview.R
import com.example.kotlinlistview.dtos.UserDto

class UserListAdapter(private var activity: Activity, private var items: ArrayList<UserDto>): BaseAdapter() {

    private class ViewHolder(row: View?){
        var textViewName: TextView? = null
        var textViewComment: TextView? = null

        init {
            this.textViewName = row?.findViewById<TextView>(R.id.textViewName)
            this.textViewComment = row?.findViewById<TextView>(R.id.textViewComment)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder
        if(convertView == null){
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.user_list_row, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var userDto = items[position]
        viewHolder.textViewName?.text = userDto.name
        viewHolder.textViewComment?.text = userDto.comment

        return view as View
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

}