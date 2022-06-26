package com.example.databaseexamexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name , number;
    DatabaseHandler handler;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new DatabaseHandler(this);

        name = findViewById(R.id.cname);
        number = findViewById(R.id.cnumber);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cname = name.getText().toString();
                String cnumber = number.getText().toString();

                boolean ans = handler.addcontact(cname,cnumber);
                if (ans){
                    Toast.makeText(MainActivity.this, "Successfully Entered!!!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Error!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}