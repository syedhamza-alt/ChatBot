package com.example.chatapt;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
        RecyclerView recyclerView;
        TextView welcomeTextView;
        EditText messageEditText;
        ImageButton sendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =(RecyclerView) findViewById(R.id.recView);
        welcomeTextView=findViewById(R.id.welcomeText);
        messageEditText=(EditText) findViewById(R.id.msg_edit_txt);
        sendButton=(ImageButton) findViewById(R.id.sendbtn);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question=messageEditText.getText().toString().trim();
                Toast.makeText(getApplicationContext(), question, LENGTH_LONG).show();
            }
        });

    }
}