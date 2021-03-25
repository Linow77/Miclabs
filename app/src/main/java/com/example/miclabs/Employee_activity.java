package com.example.miclabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        System.out.println("DEBUT THREADDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        new Thread(new client()).start();
        //client t = new client();
        //t.start();
        System.out.println("FIN THREADDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        //Liste à remplir avec les noms des employés
        List<String> list_name_employees = new ArrayList<>();
        List<Employee_Data> list_employee = new ArrayList<Employee_Data>();

        String[] emp1 = getResources().getStringArray(R.array.employee1_info);
        String[] emp2 = getResources().getStringArray(R.array.employee2_info);

        //Récupérer tous les employées (id, nom, prénom)

        //Les mettre dans la liste

        //a enlever
        final Employee_Data Data = new Employee_Data(1, "Imane", "Aziz",
                "imane.aziz@miclabs.com", "richard.cloos@miclabs.com",
                "C:\\Users\\richa\\AndroidStudioProjects\\Miclabs\\app\\src\\main\\res\\drawable\\imane", 0);

        list_name_employees.add(Data.f_name+" "+Data.name);

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
                Intent intent = new Intent(Employee_activity.this, EmployeeDataActivity.class);
                intent.putExtra("EMPLOYEE_ID", "7");
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
                final Scanner sc = new Scanner(System.in);//pour lire à partir du clavier

                System.out.println("On va lancer une connexion");
                InetAddress serverAddr = InetAddress.getByName("192.168.43.228");
                clientSocket = new Socket(serverAddr,12805);
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
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}