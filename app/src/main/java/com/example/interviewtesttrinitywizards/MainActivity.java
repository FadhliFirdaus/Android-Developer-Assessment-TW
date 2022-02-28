package com.example.interviewtesttrinitywizards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListContactsAdapter.ItemClickListener {
    RecyclerView contactsRecycler;
    ListContactsAdapter adapter;
    ArrayList<ContactsObject> arrayList;
    private static MainActivity instance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;
        getSupportActionBar().hide();
        contactsRecycler = findViewById(R.id.contactsRecyclerView);
        arrayList = new ArrayList<>();
        adapter= new ListContactsAdapter(getApplicationContext(), arrayList);
        contactsRecycler.setAdapter(adapter);
        contactsRecycler.setLayoutManager(new LinearLayoutManager(this));
        parseJSON();
        adapter.notifyDataSetChanged();
    }

    public void changeContactsData(int position, String newFirstName, String newLastName, String newEmail, String newPhoneNumber) {
        arrayList.get(position).setFirstName(newFirstName);
        arrayList.get(position).setLastName(newLastName);
        arrayList.get(position).setEmail(newEmail);
        arrayList.get(position).setPhonenNumber(newPhoneNumber);
    }

    private void parseJSON()  {
        JSONArray jsonarray = null;
        try {
            jsonarray = new JSONArray(jsonString);
            for (int i = 0; i < 100 ; i++) {
                ContactsObject tempObject = new ContactsObject("", "", "", "", "");
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                if(jsonobject.has("firstName")) {
                    tempObject.setFirstName(jsonobject.getString("firstName"));
                }
                if(jsonobject.has("lastName")) {
                    tempObject.setLastName(jsonobject.getString("lastName"));
                }
                if(jsonobject.has("email")) {
                    tempObject.setEmail(jsonobject.getString("email"));
                }
                if(jsonobject.has("id")) {
                    tempObject.setId(jsonobject.getString("id"));
                }
                if(jsonobject.has("phone")) {
                    tempObject.setPhonenNumber(jsonobject.getString("phone"));
                }
                arrayList.add(tempObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent myIntent = new Intent(MainActivity.this, SecondScreenActivity.class);
        ContactsObject tempObject = arrayList.get(position);
        myIntent.putExtra("firstName", tempObject.getFirstName());
        myIntent.putExtra("lastName", tempObject.getLastName());
        myIntent.putExtra("id", tempObject.getId());
        myIntent.putExtra("phone", tempObject.getPhonenNumber());
        myIntent.putExtra("email", tempObject.getEmail());
        startActivity(myIntent);
    }

    String jsonString = "[{\n" +
            "\t\t\"id\": \"5c8a80f52dfee238898d64cf\",\n" +
            "\t\t\"firstName\": \"Phoebe\",\n" +
            "\t\t\"lastName\": \"Monroe\",\n" +
            "\t\t\"email\": \"phoebemonroe@furnafix.com\",\n" +
            "\t\t\"phone\": \"(903) 553-3410\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f575270ddb54a18f86\",\n" +
            "\t\t\"firstName\": \"Lidia\",\n" +
            "\t\t\"lastName\": \"Wilkins\",\n" +
            "\t\t\"email\": \"lidiawilkins@furnafix.com\",\n" +
            "\t\t\"phone\": \"(997) 482-3866\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f57a27f272ab4272f9\",\n" +
            "\t\t\"firstName\": \"Gertrude\",\n" +
            "\t\t\"lastName\": \"Mccormick\",\n" +
            "\t\t\"email\": \"gertrudemccormick@furnafix.com\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f5e2ad4c1edc5cc5d9\",\n" +
            "\t\t\"firstName\": \"Maxine\",\n" +
            "\t\t\"lastName\": \"Brady\",\n" +
            "\t\t\"email\": \"maxinebrady@furnafix.com\",\n" +
            "\t\t\"phone\": \"(919) 469-2468\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f5437a24a66ac7e0c5\",\n" +
            "\t\t\"firstName\": \"Willie\",\n" +
            "\t\t\"lastName\": \"Gonzalez\",\n" +
            "\t\t\"phone\": \"(892) 456-3603\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f5a7d3d251ba82df41\",\n" +
            "\t\t\"firstName\": \"Oliver\",\n" +
            "\t\t\"lastName\": \"Floyd\",\n" +
            "\t\t\"email\": \"oliverfloyd@furnafix.com\",\n" +
            "\t\t\"phone\": \"(953) 421-2772\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f5d3c01af26b266b13\",\n" +
            "\t\t\"firstName\": \"Elliott\",\n" +
            "\t\t\"lastName\": \"Fry\",\n" +
            "\t\t\"email\": \"elliottfry@furnafix.com\",\n" +
            "\t\t\"phone\": \"(869) 557-2814\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f597cdf9c2fc4f8466\",\n" +
            "\t\t\"firstName\": \"Hancock\",\n" +
            "\t\t\"lastName\": \"Foreman\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f537cded38d718ecf5\",\n" +
            "\t\t\"firstName\": \"Hood\",\n" +
            "\t\t\"lastName\": \"Kline\",\n" +
            "\t\t\"email\": \"hoodkline@furnafix.com\",\n" +
            "\t\t\"phone\": \"(997) 596-2026\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f531ed87bee8d951d6\",\n" +
            "\t\t\"firstName\": \"Adams\",\n" +
            "\t\t\"lastName\": \"Phelps\",\n" +
            "\t\t\"email\": \"adamsphelps@furnafix.com\",\n" +
            "\t\t\"phone\": \"(847) 570-2622\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f537a8602ee2be6b6d\",\n" +
            "\t\t\"firstName\": \"Ramos\",\n" +
            "\t\t\"lastName\": \"Nieves\",\n" +
            "\t\t\"email\": \"ramosnieves@furnafix.com\",\n" +
            "\t\t\"phone\": \"(808) 550-3692\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f57ba5cd82a37a039c\",\n" +
            "\t\t\"firstName\": \"White\",\n" +
            "\t\t\"lastName\": \"Marsh\",\n" +
            "\t\t\"email\": \"whitemarsh@furnafix.com\",\n" +
            "\t\t\"phone\": \"(943) 403-2609\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f5d502bbf9f69e8b6d\",\n" +
            "\t\t\"firstName\": \"Concepcion\",\n" +
            "\t\t\"lastName\": \"Crane\",\n" +
            "\t\t\"email\": \"concepcioncrane@furnafix.com\",\n" +
            "\t\t\"phone\": \"(992) 499-2570\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f5000661cb7e325e17\",\n" +
            "\t\t\"firstName\": \"Rhonda\",\n" +
            "\t\t\"lastName\": \"Mckinney\",\n" +
            "\t\t\"email\": \"rhondamckinney@furnafix.com\",\n" +
            "\t\t\"phone\": \"(887) 477-3521\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f59283e24a4e526335\",\n" +
            "\t\t\"firstName\": \"Hilda\",\n" +
            "\t\t\"lastName\": \"Holder\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f52aec26a5edc4e17c\",\n" +
            "\t\t\"firstName\": \"Burks\",\n" +
            "\t\t\"lastName\": \"Aguilar\",\n" +
            "\t\t\"email\": \"burksaguilar@furnafix.com\",\n" +
            "\t\t\"phone\": \"(847) 431-2033\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f5b3a1e477360db964\",\n" +
            "\t\t\"firstName\": \"Lorene\",\n" +
            "\t\t\"lastName\": \"Stewart\",\n" +
            "\t\t\"email\": \"lorenestewart@furnafix.com\",\n" +
            "\t\t\"phone\": \"(895) 440-2387\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f57dab375acf5030c1\",\n" +
            "\t\t\"firstName\": \"Susana\",\n" +
            "\t\t\"lastName\": \"Short\",\n" +
            "\t\t\"email\": \"susanashort@furnafix.com\",\n" +
            "\t\t\"phone\": \"(831) 501-3483\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f523e488dd917a6e45\",\n" +
            "\t\t\"firstName\": \"Lawson\",\n" +
            "\t\t\"lastName\": \"French\",\n" +
            "\t\t\"email\": \"lawsonfrench@furnafix.com\",\n" +
            "\t\t\"phone\": \"(860) 430-3555\"\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"id\": \"5c8a80f5e3d1f2f2967c4621\",\n" +
            "\t\t\"firstName\": \"Paula\",\n" +
            "\t\t\"lastName\": \"Turner\",\n" +
            "\t\t\"email\": \"paulaturner@furnafix.com\",\n" +
            "\t\t\"phone\": \"(873) 553-3808\"\n" +
            "\t}\n" +
            "]";


}