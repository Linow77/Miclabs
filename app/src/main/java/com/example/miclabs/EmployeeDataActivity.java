package com.example.miclabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.util.LogPrinter;
import android.widget.ImageView;
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
    private ImageView imageView;
    private int[] images = new int[2];

    public void setTextView(TextView tv1, String text) {
        tv1.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_data);
        images[0] = R.drawable.random_girl;
        images[1] = R.drawable.random_boy;

        //Demander les infos de l'employee via son id
        employee_id = getIntent().getStringExtra("EMPLOYEE_ID");

        if(employee_id.equals("0")){
            Data = new Employee_Data(0, "Julie", "Fortmont",
                    "jfortmont@miclabs.com", "mdela@miclabs.com",
                    2);
        }else if (employee_id.equals("1")){
            Data = new Employee_Data(1, "Baptiste", "Haumont",
                    "bhaumont@miclabs.com", "mdela@miclabs.com",
                    0);
        }

        // Get the employee's information
        name = findViewById(R.id.textView4);
        setTextView(name, Data.name);
        f_name = findViewById(R.id.textView5);
        setTextView(f_name, Data.f_name);
        id_employe = findViewById(R.id.textView8);
        setTextView(id_employe, Integer.toString(Data.id_employee));
        mail_address = findViewById(R.id.textView10);
        setTextView(mail_address, Data.mail_address);
        chief_address = findViewById(R.id.textView14);
        setTextView(chief_address, Data.chief_address);
        missing_mask_counter = findViewById(R.id.textView12);
        setTextView(missing_mask_counter, Integer.toString(Data.missing_mask_counter));
        ImageView myImageView = findViewById(R.id.imageView);
        myImageView.setImageResource(images[Data.id_employee]);

    }

}