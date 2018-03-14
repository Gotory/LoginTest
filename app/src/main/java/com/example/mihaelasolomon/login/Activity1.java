package com.example.mihaelasolomon.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;


public class Activity1 extends AppCompatActivity {

    private TextView tv;
    private Button bc;
    public String username;

    private BroadcastReceiver bcr;
    public static List<User> list;
    public static UserAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        tv = findViewById(R.id.textView2);
        bc = findViewById(R.id.button3);
        username = getIntent().getStringExtra("user");
        tv.setText(getString(R.string.welcome, username));

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent();
                x.setAction("broadcast");
                x.putExtra("user",username);
                sendBroadcast(x);
            }
        });

        IntentFilter filter = new IntentFilter();
        filter.addAction("broadcast");

        bcr = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getAction().equals("broadcast")) {
                    Toast.makeText(context, intent.getStringExtra("user"), Toast.LENGTH_SHORT).show();
                }
            }
        };

        getApplicationContext().registerReceiver(bcr, filter);

        ListView lv = findViewById(R.id.listview1);

        DBHelper dbhelper = new DBHelper(getApplicationContext());

        list = dbhelper.getUsers(dbhelper);

        adp = new UserAdapter(this, R.layout.list_item, list);

        lv.setAdapter(adp);

        Button cumilcheama = findViewById(R.id.button5);


        cumilcheama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new task().execute("un string care nu face nimic");
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getApplicationContext().unregisterReceiver(bcr);
    }

    private class task extends AsyncTask<String, Void, String>
    {
        int nr1 = 0;
        int suma = 1;



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            while (true) {
                nr1++;
                if(nr1%1000000==0){
                    Log.d("APPLOG", Integer.toString(nr1));
                    nr1 = 0;
                }
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(Activity1.this, Integer.toString(suma), Toast.LENGTH_SHORT).show();
        }
    }
}
