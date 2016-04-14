package com.example.alexanderlombardo.todoproject1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
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
    }


}