package com.practicas.pmdm.pmdm_t4a8_granel_raul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private List<User> usersList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init Components
        spinner = findViewById(R.id.spinner);
        usersList = getUsersList();
        ArrayAdapter<User> adapter = null;

        if (null == usersList) {
            usersList = new ArrayList<>();
            User user = new User();
            user.setId(0);
            user.setName("No existen datos para mostrar.");

            usersList.add(user);
        }
        adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, usersList);
        spinner.setAdapter(adapter);
    }

    public List<User> getUsersList() {
        ArrayList<User> usersList = new ArrayList<User>();
        usersList.add(new User(1, "Raul", "Garcia", "Blanco"));
        usersList.add(new User(1, "Maria", "Paton", "Melero"));
        usersList.add(new User(1, "Gemma", "Black", "Manez"));
        usersList.add(new User(1, "Toni", "Gomez", "Tirant"));
        usersList.add(new User(1, "Laura", "Gerona", "Bezos"));

        return usersList;
    }

}