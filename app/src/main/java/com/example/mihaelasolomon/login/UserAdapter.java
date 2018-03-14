package com.example.mihaelasolomon.login;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


import java.util.List;


public class UserAdapter extends ArrayAdapter<User> {

    Context context;
    List<User> users = null;

    UserAdapter(@NonNull Context context, int resource, List<User> users) {
        super(context, resource, users);
        this.context=context;
        this.users=users;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            row = inflater.inflate(R.layout.list_item, null);
        }

        final User user = this.users.get(position);
        TextView name = row.findViewById(R.id.textView3);
        TextView mail = row.findViewById(R.id.textView4);
        Button button = row.findViewById(R.id.button4);
        name.setText(user.user);
        mail.setText(user.email);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbhelper = new DBHelper(getContext());
                dbhelper.deleteUser(user.user, dbhelper, getContext());
                Activity1.list.remove(position);
                Activity1.adp.notifyDataSetChanged();
            }
        });

        return row;
    }
}
