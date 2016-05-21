package com.example.xavier.homework_week02_app_material_design;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class Details extends AppCompatActivity {


    TextView full_name;
    TextView date;
    TextView phone;
    TextView email;
    TextView description;
    int day, month, year;
    String fullName;
    String phoneString;
    String emailString;
    String descriptionString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
        Bundle bundle = getIntent().getExtras();
        fullName = bundle.getString("fullName");
        phoneString = bundle.getString("phone");
        emailString = bundle.getString("email");
        descriptionString = bundle.getString("description");
        full_name.setText(fullName);
        phone.setText(new StringBuilder().append(phone.getText().toString()).append(" ").append(phoneString));
        email.setText(new StringBuilder().append(email.getText().toString()).append(" ").append(emailString));
        description.setText(new StringBuilder().append(description.getText().toString()).append(" ").append(descriptionString));
        day = (bundle.getInt("day"));
        month = (bundle.getInt("month")) + 1;

        year = (bundle.getInt("year"));
        date.setText(new StringBuilder().append(date.getText().toString()).append(day).append("/").append(month).append("/").append(year));
    }

    public void init() {
        full_name = (TextView) findViewById(R.id.tv_full_name);
        date = (TextView) findViewById(R.id.date);
        phone = (TextView) findViewById(R.id.phone);
        email = (TextView) findViewById(R.id.email);
        description = (TextView) findViewById(R.id.description);
    }


    public void edit(View v) {
        prevActivity();

    }

    public void prevActivity(){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("fullName", fullName);
        i.putExtra("day", day);
        i.putExtra("month", month-1);
        i.putExtra("year", year);
        i.putExtra("phone", phoneString);
        i.putExtra("email", emailString);
        i.putExtra("description", descriptionString);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        prevActivity();
    }

}
