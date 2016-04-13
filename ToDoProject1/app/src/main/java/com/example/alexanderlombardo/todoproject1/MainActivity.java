package com.example.alexanderlombardo.todoproject1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> getNewList;
    ArrayAdapter<String> mAdapter;
    ListView lvItems;
    Button listbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getNewList.add("Testing List");

    }



    public void listAdd(View v) {
        EditText getNewList = (EditText) findViewById(R.id.getNewList);
        String itemText = getNewList.getText().toString();
        mAdapter.add(itemText);
        getNewList.setText("");
    }

//    public void onAddItem(View v) {
//        EditText getNewItem = (EditText) findViewById(R.id.getNewItem);
//        String itemText = etNewItem.getText().toString();
//        itemsAdapter.add(itemText);
//        getNewItem.setText("");
//    }


}
