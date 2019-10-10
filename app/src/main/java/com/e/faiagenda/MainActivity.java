package com.e.faiagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ICONO EN BARRA
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }




    public void openContacts(View view){

        Intent intent = new Intent(this,ContactsActivity.class);
        startActivity(intent);
    }

    public void openCalendar(View view){

        Intent intent = new Intent(this,CalendarActivity.class);
        startActivity(intent);
    }
}
