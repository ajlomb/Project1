package com.example.alexanderlombardo.todoproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class todolistitem extends MainActivity {

//          **DEFINING VARIABLES FOR FUNCTIONALITY**
    ArrayList<String> arrayListItem;
    ArrayAdapter<String> arrayAdapterItem;
    public ListView listItem;

    public void onCreate(Bundle savedInstanceState) {                   //   **BUILDS ACTIVITY PAGE FROM XML
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_todolist);

//          **CREATES VARIABLE FOR DATA TO BE PASSED INTO FROM MAIN ACTIVITY; LINKS DATA TO TEXTVIEW
        TextView musky = (TextView)findViewById(R.id.humpty);
        String elonMusk = getIntent().getStringExtra("skeletonKey");    // **CREATES VARIABLE FOR DATA FROM MAIN ACTIVITY PASSED THROUGH INTENT
        musky.setText(String.valueOf(elonMusk));                        // **CONNECTS/SETS TEXTVIEW TO VARIABLE DEFINED ABOVE

//          **SETS UP LISTS AND LINKS THEM TO XML LAYOUT
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

//          **CREATES BUTTON FUNCTIONALITY, PASSES EDITTEXT FIELD THROUGH ARRAY TO DISPLAY LIST ITEMS
    public void listAddTask(View v) {
        String listAddItem = ((EditText)findViewById(R.id.editTextTwo)).getText().toString().trim();
          if (listAddItem.isEmpty()){                                   //  **KEEPS BLANK EDITTEXT FROM BEING PASSED INTO THE ARRAY
              Toast.makeText(todolistitem.this, "Error, Empty", Toast.LENGTH_LONG).show();
              return;
          }
        arrayAdapterItem.add(listAddItem);                              //  **MAKING TEXTEDIT FIELD FRIENDLY BY CLEARING AFTER BUTTON CLICK**
        EditText editTextTwo = (EditText)findViewById(R.id.editTextTwo);
        editTextTwo.setText("");

    }

}