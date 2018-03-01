package com.example.mihaelasolomon.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button login;
    public EditText user;
    public EditText pass;
    private SharedPreferences sharedprefs;
    public TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.button);
        user = findViewById(R.id.editText2);
        pass = findViewById(R.id.editText);
        register = findViewById(R.id.textView);

        sharedprefs = this.getApplicationContext().getSharedPreferences("sharedprefs", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedprefs.edit();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(reg);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(MainActivity.this, Activity1.class);
                x.putExtra("user", "test");
                MainActivity.this.startActivity(x);
            }
        });
    }



}
