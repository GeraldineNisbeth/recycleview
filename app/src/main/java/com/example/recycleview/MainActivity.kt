package com.example.recycleview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val Request_code = 1

    var contacts = ArrayList<Contact>()
    var contactAdapter = ContactAdapter(contacts)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadContacts()
        initView()
    }

    private fun initView(){
        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)

    }

    private fun loadContacts() {
        contacts.add(Contact("Jauna", "98784541"))
        contacts.add(Contact("Geraldine", "98784541"))
        contacts.add(Contact("Martin", "98784541"))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this,activity_contact ::class.java)
        //startActivity(intent) este es un envio normal peor nosotros necesitamos qeu nos de las variables que mandamos desdea fuera
        startActivityForResult(intent, Request_code)

        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == Request_code){
            if(resultCode == Activity.RESULT_OK){
                val name = data!!.getStringExtra("keyName")
                val telephone = data!!.getStringExtra("keyTelephone")

                val contact =Contact(name,telephone)
                contacts.add(contact)
            }
        }
    }
}
