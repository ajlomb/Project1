package com.example.alexanderlombardo.todoproject1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//      **DEFINING CLASSES (AND ASSIGNING VARIABLES?)**

    ArrayList<String> arrayListMaster;
    ArrayAdapter<String> arrayAdapterMaster;
    public ListView listView;

//      **BUILDS ARRAY LIST AND SETS VIEW BASED ON XML; **

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayListMaster = new ArrayList<>();
        arrayAdapterMaster = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListMaster);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapterMaster);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {         //**SETS LONG CLICK LISTENER ON LIST**
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String pos = arrayAdapterMaster.getItem(position);
                arrayAdapterMaster.remove(pos);
                return true;
            }
        });

//      **CLICK TO MOVE TO ITEM LIST**

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(MainActivity.this, todolistitem.class);
                intent.putExtra("position", position);
                String listHeader = arrayListMaster.get(position);
                intent.putExtra("skeletonKey", listHeader);
                startActivity(intent);
        }


    });
    }

//      **ADDS ENTRY IN EDIT TEXT FIELD TO MAIN LIST WHEN BUTTON CLICKED; CLEARS DATA AFTER BUTTON CLICK**

    public void listAddPage(View v) {
        String listAddList = ((EditText)findViewById(R.id.editText)).getText().toString().trim();
            if(listAddList.isEmpty()){
                return;
            }
        arrayAdapterMaster.add(listAddList);
        EditText editText = (EditText)findViewById(R.id.editText);
        editText.setText("");
    }
}

