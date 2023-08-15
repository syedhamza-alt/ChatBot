package com.example.chatapt;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        RecyclerView recyclerView;
        TextView welcomeTextView;
        EditText messageEditText;
        ImageButton sendButton;
        List<Message> messageList;

        MessageAdapter messageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageList=new ArrayList<>();

        recyclerView =(RecyclerView) findViewById(R.id.recView);
        welcomeTextView=(TextView) findViewById(R.id.welcomeText);
        messageEditText=(EditText) findViewById(R.id.msg_edit_txt);
        sendButton=(ImageButton) findViewById(R.id.sendbtn);

        //rec View
        messageAdapter =new MessageAdapter(messageList);
        recyclerView.setAdapter(messageAdapter);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setStackFromEnd(true);
        recyclerView.setLayoutManager(llm);

        sendButton.setOnClickListener(view -> {
            String question=messageEditText.getText().toString().trim();
              Toast.makeText(this, question, LENGTH_LONG).show();
            addToChat(question,Message.sent_by_me);
        });

    }


    void addToChat(String message, String sentBy){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageList.add(new Message(message,sentBy));
                messageAdapter.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(messageAdapter.getItemCount());
            }
        });
    }
}