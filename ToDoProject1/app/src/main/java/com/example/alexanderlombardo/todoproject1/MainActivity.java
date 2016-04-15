package com.example.alexanderlombardo.todoproject1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//      **DEFINING CLASSES(?) SO THINGS DON'T DIE**

    ArrayList<String> arrayListMaster;
    ArrayAdapter<String> arrayAdapterMaster;
    public ListView listView;

//      **BUILDS ARRAY LIST AND SETS VIEW BASED ON XML**

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      **TELLS ARRAYLIST WHERE TO PASS DATA, ASSIGNING VARIABLES TO CLASSES(?)**
        arrayListMaster = new ArrayList<>();
        arrayAdapterMaster = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListMaster);
        listView = (ListView) findViewById(R.id.listView);                                      //**LINKS LISTVIEW VARIABLE TO LISTVIEW IN LAYOUT
        listView.setAdapter(arrayAdapterMaster);                                                //**INFORMS LISTVIEW VARIABLE WHICH ADAPTER TO PULL DATA FROM


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {         //**SETS LONG CLICK LISTENER ON LIST
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String pos = arrayAdapterMaster.getItem(position);
                arrayAdapterMaster.remove(pos);                                                 //**REMOVES ITEM FROM LONGCLICKED POSITION
                return true;
            }
        });

//      **CLICK TO MOVE TO ITEM LIST FOR LISTITEM CLICKED ON**

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
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
            if(listAddList.isEmpty()){                                  //  **KEEPS EMPTY STRINGS FROM BEING ENTERED TO LIST
              Toast.makeText(MainActivity.this, "Error, Empty", Toast.LENGTH_LONG).show();                   // ADD TOAST MESSAGE IF EMPTY STRING IS ENTERED "ERROR, ECT"
                return;
            }
        arrayAdapterMaster.add(listAddList);
        EditText editText = (EditText)findViewById(R.id.editText);
        editText.setText("");                                           //  **CLEARS EDITTEXT FIELD ON BUTTON CLICK
    }
}

