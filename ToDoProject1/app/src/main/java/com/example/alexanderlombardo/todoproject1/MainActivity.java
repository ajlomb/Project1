package com.example.alexanderlombardo.todoproject1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrayListToDo;
    ArrayAdapter<String> arrayAdapterToDo;
    public ListView listView;

//      **NOT REALLY SURE WHAT THIS IS DOING YET....  Building the Array List?**

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayListToDo = new ArrayList<String>();
        arrayAdapterToDo = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListToDo);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapterToDo);

 //       listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

   //     });
    }

//      **ADDS A NEW ENTRY IN EDIT TEXT FIELD TO MAIN LIST WHEN BUTTON CLICKED**

    public void listAddPage(View v) {

        String listAddList = ((EditText)findViewById(R.id.editText)).getText().toString().trim();

        if(listAddList.isEmpty()){
            return;
        }
        arrayAdapterToDo.add(listAddList);
        EditText editText = (EditText)findViewById(R.id.editText);
        editText.setText("");
    }



    //**SET LONG CLICK TO DELETE ITEMS HERE**
//    public void itemAddList(View v) {
//
//        arrayAdapterToDo.notifyDataSetChanged();
//    }

//      **INTENT TO MOVE TO ITEM LIST**
//        Intent intent = new Intent(MainActivity.this, todolistitem.class);


}
