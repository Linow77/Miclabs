package com.example.miclabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Employee_activity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_activity);

        List<String> list_name_employees = new ArrayList<>();

        String[] emp1 = getResources().getStringArray(R.array.employee1_info);
        String[] emp2 = getResources().getStringArray(R.array.employee2_info);

        list_name_employees.add(emp1[0]);
        list_name_employees.add(emp2[0]);
        list_name_employees.add(emp1[0]);
        list_name_employees.add(emp2[0]);
        list_name_employees.add(emp1[0]);
        list_name_employees.add(emp2[0]);
        list_name_employees.add(emp1[0]);
        list_name_employees.add(emp2[0]);
        list_name_employees.add(emp1[0]);
        list_name_employees.add(emp2[0]);
        list_name_employees.add(emp1[0]);
        list_name_employees.add(emp2[0]);
        list_name_employees.add(emp1[0]);
        list_name_employees.add(emp2[0]);
        list_name_employees.add(emp1[0]);
        list_name_employees.add(emp2[0]);
        list_name_employees.add(emp1[0]);
        list_name_employees.add(emp2[0]);

        mListView = (ListView) findViewById(R.id.listView);

        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(Employee_activity.this,
                android.R.layout.simple_list_item_1,list_name_employees);
        mListView.setAdapter(adapter);

    }





}