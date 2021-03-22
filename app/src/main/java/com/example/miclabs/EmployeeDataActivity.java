package com.example.miclabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.util.LogPrinter;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeDataActivity extends AppCompatActivity {
    private Employee_Data Data;
    String employee_id;
    private TextView name;
    private TextView f_name;
    private TextView id_employe;
    private TextView mail_address;
    private TextView chief_address;
    private TextView missing_mask_counter;

    public void setTextView(TextView tv1, String text) {
        tv1.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_data);
        employee_id = getIntent().getStringExtra("EMPLOYEE_ID");
        Log.d("debug", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"+employee_id);

        //Demander les infos de l'employee via son id
        Data = new Employee_Data(Integer.parseInt(employee_id), "Imane", "Aziz",
                "imane.aziz@miclabs.com", "richard.cloos@miclabs.com",
                "C:\\Users\\richa\\AndroidStudioProjects\\Miclabs\\app\\src\\main\\res\\drawable\\imane", 0);
        // Get the employee's information
        name = (TextView) findViewById(R.id.textView4);
        setTextView(name, Data.name);
        f_name = (TextView) findViewById(R.id.textView5);
        setTextView(f_name, Data.f_name);
        id_employe = (TextView) findViewById(R.id.textView8);
        setTextView(id_employe, Integer.toString(Data.id_employee));
        mail_address = (TextView) findViewById(R.id.textView10);
        setTextView(mail_address, Data.mail_address);
        chief_address = (TextView) findViewById(R.id.textView14);
        setTextView(chief_address, Data.chief_address);
        missing_mask_counter = (TextView) findViewById(R.id.textView12);
        setTextView(missing_mask_counter, Integer.toString(Data.missing_mask_counter));
    }

}