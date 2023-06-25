package com.example.vilkvezys.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.vilkvezys.R;
import com.example.vilkvezys.models.Contact;
import com.example.vilkvezys.models.ContactAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        ListView listViewContacts = root.findViewById(R.id.listViewContacts);

        List<Contact> contactList = getContactList();

        ContactAdapter contactAdapter = new ContactAdapter(requireContext(), contactList, getChildFragmentManager());
        listViewContacts.setAdapter(contactAdapter);

        return root;
    }

    private List<Contact> getContactList() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("John Doe", "1234567890"));
        contacts.add(new Contact("Jane Smith", "9876543210"));
        return contacts;
    }
}
