package com.example.vilkvezys.models;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.example.vilkvezys.R;
import com.example.vilkvezys.ui.contact.ContactDetailsActivity;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    private final Context context;
    private final List<Contact> contacts;

    public ContactAdapter(Context context, List<Contact> contacts, FragmentManager childFragmentManager) {
        super(context, R.layout.list_item_contact, contacts);
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_contact, parent, false);
        }

        final Contact contact = contacts.get(position);

        TextView nameTextView = convertView.findViewById(R.id.textViewName);
        TextView phoneNumberTextView = convertView.findViewById(R.id.textViewPhoneNumber);

        nameTextView.setText(contact.getName());
        phoneNumberTextView.setText(contact.getPhoneNumber());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle contact click event
                Bundle bundle = new Bundle();
                bundle.putString("name", contact.getName());
                bundle.putString("phoneNumber", contact.getPhoneNumber());

                Intent intent = new Intent(context, ContactDetailsActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
