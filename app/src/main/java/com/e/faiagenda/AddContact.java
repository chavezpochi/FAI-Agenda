package com.e.faiagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AddContact extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;
    private int year;
    private int month;
    private int dayOfMonth;

    private EditText et_name,et_telephone,et_birth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        final EditText editText = (EditText) findViewById(R.id.userdate);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(AddContact.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editText.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                    }
                },year,month, dayOfMonth);
                datePickerDialog.show();
            }
        });

        Button createContact

    }

    public void AddContacts(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase dbContacts = admin.getWritableDatabase();

        String name = et_name.getText().toString();
        String telephone = et_telephone.getText().toString();
        String birth = et_birth.getText().toString();

        birth = dateFormat(birth);

        if(!name.isEmpty() && !telephone.isEmpty() && !birth.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("name",name);
            registro.put("telephone",telephone);
            registro.put("birth",birth);
            dbContacts.insert("contact",null,registro);
            dbContacts.close();
            et_birth.setText("");
            et_name.setText("");
            et_telephone.setText("");
            Toast.makeText(this, "Se cargo con exito", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Todos los campos deben estar completos",Toast.LENGTH_SHORT).show();
        }

    }

    private String dateFormat(String date){
        String[] parts = date.split("-");
        String day, month, year;

        day = parts[0];
        month = parts[1];
        year = parts[2];

        return year+"-"+month+"-"+day;
    }
}
