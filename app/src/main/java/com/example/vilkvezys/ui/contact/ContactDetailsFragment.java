package com.example.vilkvezys.ui.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.vilkvezys.R;

public class ContactDetailsFragment extends Fragment {

    private String contactName;
    private String contactPhoneNumber;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            contactName = getArguments().getString("name");
            contactPhoneNumber = getArguments().getString("phoneNumber");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact_details, container, false);

        TextView textViewContactName = root.findViewById(R.id.textViewContactName);
        TextView textViewContactPhoneNumber = root.findViewById(R.id.textViewContactPhoneNumber);

        textViewContactName.setText(contactName);
        textViewContactPhoneNumber.setText(contactPhoneNumber);

        setActionBarTitle(contactName);

        return root;
    }

    private void setActionBarTitle(String title) {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }
}
