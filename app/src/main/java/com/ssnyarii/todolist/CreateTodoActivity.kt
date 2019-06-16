package com.ssnyarii.todolist

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_todo.*

@Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")

class CreateTodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_todo)

        lateinit var title : String

        saveButton.setOnClickListener {
            title = if(importantCheckBox.isChecked) {
                "❗️ ${titleEditText.text}"
            } else {
                titleEditText.text.toString()
            }

            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            var todos = prefs.getStringSet(getString(R.string.TODO_STRINGS), setOf()).toMutableSet()
            todos.add(title)

            prefs.edit().putStringSet("todostrings", todos).apply()

            finish()
        }
    }
}
