package com.example.listas.views.add

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.listas.views.todo.TodoActivity
import com.example.listas.R
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity(), AddFragment.OnFragmentInteractionListener {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_add)
            setSupportActionBar(toolbar)

            supportFragmentManager.beginTransaction()
                .add(R.id.container, AddFragment(), null)
                .commit()



//        var adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item) as ArrayAdapter<CharSequence>
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinner_cat.setAdapter(adapter)
////        spinner_cat.onItemSelectedListener(this)

    }

    override fun onFragmentInteraction(input: String) {
        setResult(
            Activity.RESULT_OK,
            Intent(this, TodoActivity::class.java)
                .putExtra(TodoActivity.resultInput, input)
        )
        finish()
    }
}
