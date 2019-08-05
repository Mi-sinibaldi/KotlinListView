package com.example.kotlinlistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.kotlinlistview.adapters.UserListAdapter
import com.example.kotlinlistview.dtos.UserDto

class MainActivity : AppCompatActivity() {

    var listView : ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById<ListView>(R.id.listView)

        var adapter = UserListAdapter(this, generateData())
        listView?.adapter = adapter

        adapter.notifyDataSetChanged()
    }

    private fun generateData(): ArrayList<UserDto> {
        var result = ArrayList<UserDto>()

        for(i in 0..9){
            var user = UserDto("Bett", "Thank you for watching ;)")
            result.add(user)
        }

        return result
    }
}
