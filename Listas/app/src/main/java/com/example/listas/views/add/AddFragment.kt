package com.example.listas.views.add

import android.content.Context
import android.os.Bundle
import android.renderscript.RenderScript
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.listas.R
import com.example.listas.extensions.textString
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.layout_todo_row.*

class AddFragment : Fragment() {

    lateinit var spinner_cat : Spinner
    lateinit var spinner_text : TextView

    lateinit var spinner_prio : Spinner
    lateinit var spinner_text_prio : TextView

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(input: String, spinner_prio: String, color: String)
    }

    private var listener: OnFragmentInteractionListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addButton.setOnClickListener {
            onAddButtonPressed()
        }

        // SPINNER DE LAS CATEGORIAS
        spinner_cat = view.findViewById(R.id.spinner_category) as Spinner
        spinner_text = view.findViewById(R.id.spinner_text) as TextView

        val spinnercats = arrayOf("Work","Study","Shopping","Leisure")

        spinner_cat.adapter = ArrayAdapter<String>( view.context, android.R.layout.simple_list_item_1,spinnercats)

        spinner_cat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinner_text.text = " Please select an category"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //spinner_text.text = spinnercats.get(position)
            }
        }

        // SPINNER DE LAS PRIORIDADES

        spinner_prio = view.findViewById(R.id.spinner_prio) as Spinner
        spinner_text_prio = view.findViewById(R.id.spinner_text_prio) as TextView

        val spinnerprio = arrayOf("High Priority","Medium Priority", "Low Priority")

        spinner_prio.adapter = ArrayAdapter<String>( view.context, android.R.layout.simple_list_item_1,spinnerprio)

        spinner_prio.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinner_text_prio.text = " Please select an priority"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                spinner_text.text = spinnercats.get(position)
             //   priority.text = spinnercats.get(position)
            }

        }

    }

    private fun onAddButtonPressed() {
        if (input.textString().isEmpty()) {
            return
        }
        listener?.onFragmentInteraction(input.textString(),spinner_prio.selectedItem.toString(),spinner_cat.selectedItem.toString())
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
