package com.example.miclabs;

import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Employee_Data {
    public int id_employee;
    public String f_name;
    public String name;
    public String mail_address;
    public String chief_address;
    public File myImage;
    public FileInputStream istreamImage ;
    public int missing_mask_counter;

    public Employee_Data(int id_employee, String f_name, String name,String mail_address, String chief_address,String location, int missing_mask_counter) {
        this.id_employee = id_employee;
        this.f_name = f_name;
        this.name = name;
        this.mail_address = mail_address;
        this.chief_address = chief_address;
        this.myImage= new File(location);
        try {
            this.istreamImage = new FileInputStream(myImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.missing_mask_counter = missing_mask_counter;
    }

    public Employee_Data(int id_employee, String f_name, String name){
        this.id_employee = id_employee;
        this.f_name = f_name;
        this.name =name;
    }
}
