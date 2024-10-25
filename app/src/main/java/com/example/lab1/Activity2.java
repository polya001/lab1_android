package com.example.lab1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    TextView textItem;
    Button buttonOk;
    EditText nameItem;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        textItem=findViewById(R.id.textId);
        buttonOk=findViewById(R.id.buttonID);
        nameItem=findViewById(R.id.editTextText);

        Intent intent = getIntent();
        String greeting= intent.getStringExtra("greeting");
        textItem.setText(greeting);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = String.valueOf(nameItem.getText());
                if (name.isEmpty()){
                    Toast.makeText(Activity2.this,"Enter your name",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent();
                    intent.putExtra("name",name);
                    setResult(RESULT_OK,intent);
                    finish();


                }

            }
        });
    }


}