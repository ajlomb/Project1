package com.example.alexanderlombardo.todoproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class todolistitem extends MainActivity {

    ArrayList<String> arrayListItem;
    ArrayAdapter<String> arrayAdapterItem;
    public ListView listItem;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_todolist);
        TextView musky = (TextView)findViewById(R.id.humpty);
        String elonMusk = getIntent().getStringExtra("skeletonKey");
        musky.setText(String.valueOf(elonMusk));


        arrayListItem = new ArrayList<>();
        arrayAdapterItem = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListItem);
        listItem = (ListView) findViewById(R.id.listItem);
        listItem.setAdapter(arrayAdapterItem);
//          **SETTING LONGCLICK TO DELETE ITEMS FROM LIST**
        listItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String itm = arrayAdapterItem.getItem(position);
                arrayAdapterItem.remove(itm);
                return true;
            }
        });
    }

//          **BUSINESS END OF ADDING ITEMS TO THE LIST**
    public void listAddTask(View v) {
        String listAddItem = ((EditText)findViewById(R.id.editTextTwo)).getText().toString().trim();
            if (listAddItem.isEmpty()){
                return;
            }
        arrayAdapterItem.add(listAddItem);                      // **MAKING TEXTEDIT FIELD FRIENDLY BY CLEARING**
        EditText editTextTwo = (EditText)findViewById(R.id.editTextTwo);
        editTextTwo.setText("");

    }

}