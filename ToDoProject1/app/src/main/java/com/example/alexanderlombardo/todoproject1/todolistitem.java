package com.example.alexanderlombardo.todoproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by alexanderlombardo on 4/13/16.
 */
public class todolistitem extends MainActivity {

    ArrayList<String> arrayListItem;
    ArrayAdapter<String> arrayAdapterItem;
    public ListView listItem;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_todolist);

        arrayListItem = new ArrayList<>();
        arrayAdapterItem = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListItem);
        listItem = (ListView) findViewById(R.id.listItem);
        listItem.setAdapter(arrayAdapterItem);

        listItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {         //**SETS LONG CLICK LISTENER ON LIST**
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String itm = arrayAdapterItem.getItem(position);
                arrayAdapterItem.remove(itm);
                return true;
            }
        });
    }

    public void listAddTask(View v) {
        String listAddItem = ((EditText)findViewById(R.id.editTextTwo)).getText().toString().trim();
            if (listAddItem.isEmpty()){
                return;
            }
        arrayAdapterItem.add(listAddItem);
        EditText editTextTwo = (EditText)findViewById(R.id.editTextTwo);
        editTextTwo.setText("");
    }




}