package com.example.xavier.homework_week02_app_material_design;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextInputEditText full_name;
    DatePicker datePicker;
    TextInputEditText phone;
    TextInputEditText email;
    TextInputEditText description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Bundle bundle = getIntent().getExtras();
        int day, month, year;
        if (bundle!=null) {
            full_name.setText(bundle.getString("fullName"));
            phone.setText(bundle.getString("phone"));
            email.setText(bundle.getString("email"));
            description.setText(bundle.getString("description"));
            day = (bundle.getInt("day"));
            month = (bundle.getInt("month"));
            year = (bundle.getInt("year"));
            datePicker.updateDate(year, month, day);
        }
        // Set date.
    }

    public void init() {
        full_name = (TextInputEditText) findViewById(R.id.full_name);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        phone = (TextInputEditText) findViewById(R.id.phone);
        email = (TextInputEditText) findViewById(R.id.email);
        description = (TextInputEditText) findViewById(R.id.description);
    }

    public void second_activity(View v) {
        String fullName = full_name.getText().toString();
        String phone = this.phone.getText().toString();
        String email = this.email.getText().toString();
        String description = this.description.getText().toString();
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        Intent i = new Intent(this, Details.class);
        i.putExtra("fullName", fullName);
        i.putExtra("day", day);
        i.putExtra("month", month);
        i.putExtra("year", year);
        i.putExtra("phone", phone);
        i.putExtra("email", email);
        i.putExtra("description", description);
        startActivity(i);
        finish();
    }

}
