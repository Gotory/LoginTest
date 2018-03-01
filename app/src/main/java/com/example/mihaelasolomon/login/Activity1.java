package com.example.mihaelasolomon.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.logging.LogRecord;


public class Activity1 extends AppCompatActivity {

    private TextView tv;
    private Button bc;
    public String username;

    private BroadcastReceiver bcr;

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

        UserAdapter adp = new UserAdapter(getApplicationContext(), R.layout.list_item, dbhelper.getUsers(dbhelper));

        ArrayList<User> userss = dbhelper.getUsers(dbhelper);
        Log.d("da", userss.get(0).user.toString());



        lv.setAdapter(adp);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getApplicationContext().unregisterReceiver(bcr);
    }
}
