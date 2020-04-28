package com.example.recycleview

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_contact.view.*

class ContactAdapter(var contacts:ArrayList<Contact>) : RecyclerView.Adapter<ContactPrototype>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prototype_contact,parent,false)
        return ContactPrototype(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(contactprototype: ContactPrototype, position: Int) {
        contactprototype.bind(contacts.get(position))
    }


}

class ContactPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvname = itemView.tvname
    val tvtelefono  = itemView.tvtelefono

    fun bind(contact: Contact){
        tvname.text = contact.name
        tvtelefono.text = contact.telephone
    }
}
