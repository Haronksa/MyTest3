package com.example.mytest3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private var listView: ListView? = null
    private var btnAdd: Button? = null
    private var editNote: EditText? = null
    private var x: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()

        val arr:ArrayList<String> = ArrayList()
        arr.add("Haroon")
        arr.add("Emran")
        arr.add("Ali")

        prepareList(arr)

        handleException()

    }

    private fun handleException() {
        try {
            var sum = 10 + x!!
        }
        catch (e:NullPointerException) {
            Log.i("NullPointer", "Value x can't be null")
        }
        try {
            var sum = 10/0
        }
        catch (e:ArithmeticException) {
            Log.i("Arithmetic", "Can't divide by 0")
        }
        try {
            val arr:ArrayList<String> = ArrayList()
            arr.add("Ali")
            arr.add("Khalid")
            arr.add("Fahad")
            val name = arr[3]
        }
        catch (e:IndexOutOfBoundsException) {
            Log.i("IndexOutOfBounds", "The index is out of Array")
        }
    }

    private fun prepareList(arr: ArrayList<String>) {
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arr)

        listView?.adapter = arrayAdapter

        btnAdd?.setOnClickListener {
            arr.add(editNote?.text.toString())
            arrayAdapter.notifyDataSetChanged()
        }

        listView?.setOnItemClickListener { _, _, i, _ ->
            arr.removeAt(i)
            arrayAdapter.notifyDataSetChanged()
        }
    }

    private fun connectViews() {
        listView = findViewById(R.id.listView)
        btnAdd = findViewById(R.id.buttonAdd)
        editNote = findViewById(R.id.newNote)
    }
}