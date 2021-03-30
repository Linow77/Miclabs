package com.example.miclabs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee_activity extends AppCompatActivity {

    private ListView employeeListView;
    private Socket client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_activity);

        //Connexion au serveur
       /* System.out.println("DEBUT THREAD");
        //new ConnectionTask().execute();
        new Thread(new client()).start();

        System.out.println("FIN THREAD");*/

        //Liste à remplir avec les noms des employés
        List<String> list_name_employees = new ArrayList<>();

        String[] emp1 = getResources().getStringArray(R.array.employee1_info);
        String[] emp2 = getResources().getStringArray(R.array.employee2_info);

        //Récupérer tous les employées (id, nom, prénom)

        //Les mettre dans la liste

        //a enlever
        final Employee_Data Julie = new Employee_Data(0, "Julie", "Fortmont",
                "jfortmont@miclabs.com", "mdela@miclabs.com",
                2);

        final Employee_Data Baptiste = new Employee_Data(1, "Baptiste", "Haumont",
                "bhaumont@miclabs.com", "mdela@miclabs.com",
                0);

        list_name_employees.add(Julie.f_name+" "+Julie.name);
        list_name_employees.add(Baptiste.f_name+" "+Baptiste.name);

        //création de la listview
        employeeListView = findViewById(R.id.listView);

        // Create an ArrayAdapter from List
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, list_name_employees){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = view.findViewById(android.R.id.text1);

                // Set the text color of TextView (ListView Item)
                tv.setTextColor(getResources().getColor(R.color.colorAccent));
                tv.setTextSize(15);

                // Generate ListView Item using TextView
                return view;
            }
        };
        employeeListView.setAdapter(arrayAdapter);


        //final ArrayAdapter<String> adapter = new ArrayAdapter<>(Employee_activity.this,
               // android.R.layout.simple_list_item_1,list_name_employees);


        // OnClickListener on ListView
        employeeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(Employee_activity.this, "Employee is "+adapter.getItem(position)+" à la position:"+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Employee_activity.this, EmployeeDataActivity.class);
                intent.putExtra("EMPLOYEE_ID", String.valueOf(position));
                // start the activity connect to the specified class
                startActivity(intent);
            }
        });

    }

    class client implements Runnable{
        @Override
        public void run() {
            try {

                final Socket clientSocket;
                final BufferedReader in;
                final PrintWriter out;

                System.out.println("On va lancer une connexion");
                InetAddress serverAddr = InetAddress.getByName("192.168.43.159");
                InetSocketAddress sockAdr = new InetSocketAddress(serverAddr, 139);
                //clientSocket = new Socket(serverAddr,12805);
                clientSocket = new Socket();
                //clientSocket.setSoTimeout(10000);
                clientSocket.connect(sockAdr,100000);
                System.out.println("TEEESEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEst");
                out = new PrintWriter(clientSocket.getOutputStream());
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                //La on envoie la string pour recevoir toutes les infos
                out.println("Tout|");
                out.flush();
                /*
                 * Pour recevoir la liste reduite : 'liste reduite|'
                 * Pour recevoir les infos pour un id précis : 'id,info|'
                 * Pour recevoir la photo d'un id précis : "id,photo|'
                 */

                String msg;

                msg = in.readLine();

                System.out.println("Serveur : "+msg);

                System.out.println("Serveur déconecté");
                out.close();
                clientSocket.close();

                //Pour fermer le serveur quand on a terminé
                out.println("Fermer|");

            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                System.out.println("EREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEUR 1");
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println("EREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEUR 2");
                e.printStackTrace();
            }
        }
    }

    /*class ConnectionTask extends AsyncTask<Void,Void,String>
    {

        public String doInBackground(Void...params)
        {
            String ret = null;
            BufferedReader in = null;
            PrintWriter out = null;
            Socket socket = null;

            try {
                socket = new Socket("192.168.43.228", 12805);	//adresse IP du serveur
                in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream());

                out.println("TEST");
                ret = in.readLine();
            } catch (Exception ex) {
                // on utilise Log sous android !
                Log.e("ConnectionTask","Failure !0",ex);
            }finally {
                // il faut tout fermer hein !!!
                if (out != null) out.close();
                if (in != null)
                    try {
                        in.close();
                    } catch (Exception ex1) {
                        Log.e("ConnectionTask","Failure !1",ex1);
                    }
                try {
                    socket.close();
                } catch (Exception ex2) {
                    Log.e("ConnectionTask","Failure !2",ex2);
                }
            }
            return ret;
        }


    }*/
}