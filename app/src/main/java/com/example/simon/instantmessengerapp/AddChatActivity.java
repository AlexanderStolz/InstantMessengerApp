package com.example.simon.instantmessengerapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.simon.instantmessengerapp.database.DatabaseHelper;

public class AddChatActivity extends AppCompatActivity {
    EditText groupName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        groupName = (EditText) findViewById(R.id.editText4);
        setSupportActionBar(toolbar);
        addOnClickListener();
    }

    public void addOnClickListener(){
        Button button = findViewById(R.id.button8);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = new DatabaseHelper(view.getContext()).getReadableDatabase();
                ContentValues groupValues = new ContentValues();
                groupValues.put(DatabaseHelper.GROUP_NAME_FIELD_NAME, groupName.getText().toString());
                db.insert(DatabaseHelper.GROUP_TABLE_NAME, null, groupValues);
                db.close();
                finish();
            }
        });
    }

    public void addGroup(View view) {


        finish();
    }
}
