package com.example.namelistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_add;
    EditText et_addName;
    ListView lv_namesList;

    List<String> friends = new ArrayList<String>();
    ArrayAdapter arrayAdapter;

    String [] startingList = {"Alice", "Bob", "Charles", "Debbie"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        et_addName = findViewById(R.id.et_addName);
        lv_namesList = findViewById(R.id.lv_namesList);

        friends = new ArrayList<>(Arrays.asList(startingList));
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 ,friends);

        lv_namesList.setAdapter(arrayAdapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String newName =  et_addName.getText().toString();
               friends.add(newName);
                Collections.sort(friends);
               arrayAdapter.notifyDataSetChanged();
            }
        });

        lv_namesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Position = "  + position + " Name = " + friends.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
