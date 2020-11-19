package com.example.miclabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Employee_activity extends AppCompatActivity {

    private ListView employeeListView;
    private Socket client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_activity);

        //Connexion au serveur
        try {
            client = new Socket("192.168.0.33", 3456);

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Liste à remplir avec les noms des employés
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

        employeeListView = (ListView) findViewById(R.id.listView);

        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(Employee_activity.this,
                android.R.layout.simple_list_item_1,list_name_employees);
        employeeListView.setAdapter(adapter);

        // OnClickListener on ListView
                employeeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Employee_activity.this, "Employee is "+adapter.getItem(position)+" à la position:"+position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}