package com.example.lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCallerLauncher;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText HelloText;
    Button buttonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HelloText= findViewById(R.id.helloTextID);
        buttonOk=findViewById(R.id.buttonOkID);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = String.valueOf(HelloText.getText());
                if (newText.isEmpty()){
                    Toast.makeText(MainActivity.this,"Enter text",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent newintent = new Intent(MainActivity.this, Activity2.class);
                    newintent.putExtra("greeting",newText);

                    galleryActivityResultLauncher.launch(newintent);

                }


            }
        });
    }
    public  ActivityResultLauncher<Intent>galleryActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult res) {
                    if (res.getResultCode()== Activity.RESULT_OK){
                        String name = res.getData().getStringExtra("name");
                        String text = String.valueOf(HelloText.getText()) + ", "+ name;
                        HelloText.setText(text);


                    }
                }
            }
    );


}