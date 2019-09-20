package com.example.listas.views.add

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.listas.R
import com.example.listas.extensions.textString
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment() {

    lateinit var spinner_cat : Spinner
    lateinit var spinner_text : TextView

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(input: String)
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

        spinner_cat = view.findViewById(R.id.spinner_category) as Spinner
        spinner_text = view.findViewById(R.id.spinner_text) as TextView

        val spinnercats = arrayOf("Trabajo","Estudio","Compras","Ocio")

        spinner_cat.adapter = ArrayAdapter<String>( activity, android.R.layout.simple_list_item_1,spinnercats)

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
             //   spinner_text.text = spinnercats.get(position)
            }

        }

    }

    private fun onAddButtonPressed() {
        if (input.textString().isEmpty()) {
            return
        }
        listener?.onFragmentInteraction(input.textString())
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
