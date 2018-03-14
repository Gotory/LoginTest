package com.example.mihaelasolomon.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    public Button login;
//    public EditText user;
//    public EditText pass;
//    private SharedPreferences sharedprefs;
//    public TextView register;
    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer);

//        login = findViewById(R.id.button);
//        user = findViewById(R.id.editText2);
//        pass = findViewById(R.id.editText);
//        register = findViewById(R.id.textView);
//
//        sharedprefs = this.getApplicationContext().getSharedPreferences("sharedprefs", MODE_PRIVATE);
//
//        SharedPreferences.Editor editor = sharedprefs.edit();
//
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent reg = new Intent(MainActivity.this, RegisterActivity.class);
//                MainActivity.this.startActivity(reg);
//            }
//        });
//
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DBHelper dbh = new DBHelper(getApplicationContext());
//
//                SQLiteDatabase db = dbh.getReadableDatabase();
//
//                String query = "SELECT * FROM users_table;";
//
//                Cursor cursor = db.rawQuery(query, null);
//
//                while (cursor.moveToNext())
//                {
//                    Log.d("APPLOG", cursor.getString(cursor.getColumnIndex("USERNAME")) + " " + cursor.getString(cursor.getColumnIndex("PASSWORD")));
//                }
//
//                Intent x = new Intent(MainActivity.this, Activity1.class);
//                x.putExtra("user", "test");
//                MainActivity.this.startActivity(x);
//            }
//        });

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        switch (menuItem.getItemId()) {
                            case R.id.new_game:
                                Toast.makeText(MainActivity.this, "item1 selected", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.help:
                                Toast.makeText(MainActivity.this, "item2 selected", Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle item selection
//        switch (item.getItemId()) {
//            case R.id.new_game:
//                Toast.makeText(this, "item1 selected", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.help:
//                Toast.makeText(this, "item2 selected", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

}
