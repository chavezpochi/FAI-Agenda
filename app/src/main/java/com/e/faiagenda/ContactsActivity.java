package com.e.faiagenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ContactsActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        fragmentManager =   getSupportFragmentManager();

        ContactList fragment =  new ContactList();
        addFragment(fragment);

        final FloatingActionButton addContact = (FloatingActionButton) findViewById(R.id.add_contact);

        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addContact(v);
            }
        });

    }

    public void addContact(View view){

        Intent intent = new Intent(this,AddContact.class);
        startActivity(intent);
    }


    public void addFragment(Fragment fragment){

        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.country_fragment,fragment);
        fragmentTransaction.commit();

    }

    public void switchFragment(View view){

        Fragment fragment = fragmentManager.findFragmentById(R.id.country_fragment);
        if (fragment != null){



        }
    }



}
