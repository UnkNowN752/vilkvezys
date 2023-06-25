package com.example.vilkvezys.ui.contact;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vilkvezys.R;
import com.example.vilkvezys.message.MessageAdapter;

import java.util.ArrayList;
import java.util.List;

public class ContactDetailsActivity extends AppCompatActivity {

    private MessageAdapter messageAdapter;
    private List<String> messagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        // Set the contact name as the activity title
        String contactName = getIntent().getStringExtra("name");
        setActionBarTitle(contactName);

        // Initialize RecyclerView and its adapter
        RecyclerView recyclerView = findViewById(R.id.recyclerViewMessages);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        messagesList = new ArrayList<>();
        messageAdapter = new MessageAdapter(messagesList);
        recyclerView.setAdapter(messageAdapter);

        // Enable back button in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        EditText editTextMessage = findViewById(R.id.editTextMessage);
        findViewById(R.id.buttonSend).setOnClickListener(v -> {
            String message = editTextMessage.getText().toString().trim();
            if (!message.isEmpty()) {
                sendMessage(message);
                editTextMessage.setText("");
            }
        });
    }

    private void setActionBarTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    private void sendMessage(String message) {
        messagesList.add(message);
        messageAdapter.notifyItemInserted(messagesList.size() - 1);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle back button click event
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
