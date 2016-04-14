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

    ArrayList<String> arrayListToDo;
    ArrayAdapter<String> arrayAdapterToDo;
    public ListView listView;

//      **BUILDS ARRAY LIST AND SETS VIEW BASED ON XML; **

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayListToDo = new ArrayList<>();
        arrayAdapterToDo = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListToDo);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapterToDo);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {         //**SETS LONG CLICK LISTENER ON LIST**
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
                {
                    String pos = arrayAdapterToDo.getItem(position);
                    arrayAdapterToDo.remove(pos);
//                  arrayAdapterToDo.notifyDataSetChanged();           **NOT NEEDED WITH ADAPTER DOING DATA DESTRUCTION**
//                    switch (position){                               **SWITCH TO TEST POSITION LONG CLICK**
//                        case 0:
//                            // Add code to do when first item gets long clicked
//                            Toast.makeText(MainActivity.this,"First Item Long Clicked",Toast.LENGTH_SHORT).show();
//                            break;
//                        case 1:
//                            // Add code to do when second item gets long clicked
//                            Toast.makeText(MainActivity.this,"Second Item Long Clicked",Toast.LENGTH_SHORT).show();
//                            break;
//                        case 2:
//                            // Add code to do when third item gets long clicked
//                            Toast.makeText(MainActivity.this,"Third Item Long Clicked",Toast.LENGTH_SHORT).show();
//                            break;
//                        case 3:
//                            // Add code to do when fourth item gets long clicked
//                            Toast.makeText(MainActivity.this,"Fourth Item Long Clicked",Toast.LENGTH_SHORT).show();
//                            break;
//                    }
                    return true;
                }
        });

//      **CLICK TO MOVE TO ITEM LIST**

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int postition, short id)
            {
                Intent intent = new Intent(this, todolistitem.class);
                
            }


        });
    }


//      **ADDS ENTRY IN EDIT TEXT FIELD TO MAIN LIST WHEN BUTTON CLICKED; CLEARS DATA AFTER BUTTON CLICK**

    public void listAddPage(View v) {

        String listAddList = ((EditText)findViewById(R.id.editText)).getText().toString().trim();

        if(listAddList.isEmpty()){
            return;
        }
        arrayAdapterToDo.add(listAddList);
        EditText editText = (EditText)findViewById(R.id.editText);
        editText.setText("");
    }

      //**INTENT TO MOVE TO ITEM LIST**
 //       Intent intent = new Intent(MainActivity.this, todolistitem.class);


}
