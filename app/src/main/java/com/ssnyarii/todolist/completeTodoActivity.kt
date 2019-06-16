package com.ssnyarii.todolist

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_complete_todo.*

class completeTodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_todo)

        val todo = intent.extras.getString("title")

        todoTextView.text = todo

        completeButton.setOnClickListener {

            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            var todos = prefs.getStringSet(getString(R.string.TODO_STRINGS), setOf()).toMutableSet()

            todos.remove(todo)

            prefs.edit().putStringSet(getString(R.string.TODO_STRINGS), todos).apply()

            finish()
        }
    }
}
