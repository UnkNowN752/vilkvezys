package com.example.vilkvezys.message;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vilkvezys.R;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<String> messagesList;
    private static final int MESSAGE_SENT = 1;
    private static final int MESSAGE_RECEIVED = 2;

    public MessageAdapter(List<String> messagesList) {
        this.messagesList = messagesList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == MESSAGE_SENT) {
            view = inflater.inflate(R.layout.item_message_sent, parent, false);
        } else {
            view = inflater.inflate(R.layout.item_message_received, parent, false);
        }
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        String message = messagesList.get(position);
        holder.textViewMessage.setText(message);
    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }

    @Override
    public int getItemViewType(int position) {
        String message = messagesList.get(position);
        if (isMessageReceived(message)) {
            return MESSAGE_RECEIVED;
        } else {
            return MESSAGE_SENT;
        }
    }

    private boolean isMessageReceived(String message) {
        // Implement your logic here to determine if the message is received
        // Return true if the message is received, false if it's sent
        // In this example, we'll assume that if the message is empty or null, it is considered as received
        // Additionally, if the message is not empty or null, it is considered as sent
        return message == null || message.isEmpty();
    }




    static class MessageViewHolder extends RecyclerView.ViewHolder {

        TextView textViewMessage;

        MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMessage = itemView.findViewById(R.id.textViewMessage);
        }
    }
}

