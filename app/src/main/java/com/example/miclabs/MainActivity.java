package com.example.miclabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView employee_Activity_button;
    ImageView contact_Activity_button;
    ImageView map_Activity_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // by ID we can use each component which id is assign in xml file
        // use findViewById() to get the Button
        employee_Activity_button = findViewById(R.id.EmployeeView);
        contact_Activity_button = findViewById(R.id.ContactView);
        map_Activity_button = findViewById(R.id.MapView);

        // Add_button add clicklistener
        employee_Activity_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(MainActivity.this, Employee_activity.class);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });

        // Add_button add clicklistener
        contact_Activity_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(MainActivity.this, ContactActivity.class);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });

        // Add_button add clicklistener
        map_Activity_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                // Intents are objects of the android.content.Intent type. Your code can send them
                // to the Android system defining the components you are targeting.
                // Intent to start an activity called SecondActivity with the following code:

                Intent intent = new Intent(MainActivity.this, MapActivity.class);

                // start the activity connect to the specified class
                startActivity(intent);
            }
        });

    }




}