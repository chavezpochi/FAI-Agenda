package com.e.faiagenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import androidx.fragment.app.ListFragment;

public class ContactList extends ListFragment {

    // Array of strings storing country names
    String[] countries = new String[] {
            "Matias",
            "Rodrigo",
            "Ivan",
            "Carlos",
            "Esteban",
            "Lucas",
            "Romina",
            "Karen",
            "Sofia",
            "Pablo"
    };

    // Array of integers points to images stored in /res/drawable/
    int[] flags = new int[]{
            R.drawable.ic_contact,
            R.drawable.ic_contact,
            R.drawable.ic_contact,
            R.drawable.ic_contact,
            R.drawable.ic_contact,
            R.drawable.ic_contact,
            R.drawable.ic_contact,
            R.drawable.ic_contact,
            R.drawable.ic_contact,
            R.drawable.ic_contact
    };

    // Array of strings to store currencies
    String[] currency = new String[]{
            "299-949123",
            "299-123312",
            "299-435345",
            "299-345534",
            "299-134654",
            "299-463257",
            "299-788534",
            "299-345688",
            "299-694930",
            "299-123123"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getActivity(),"administracion",null,1);
        SQLiteDatabase dbContacts = admin.getWritableDatabase();



        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<10;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("name", "Nombre : " + countries[i]);
            hm.put("tel","Tel : " + currency[i]);
            hm.put("img_contact", Integer.toString(flags[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "img_contact","name","tel" };

        // Ids of views in listview_layout
        int[] to = { R.id.img_contact,R.id.name,R.id.tel};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.listview_layout, from, to);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


}