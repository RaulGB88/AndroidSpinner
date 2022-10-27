package com.practicas.pmdm.pmdm_t4a8_granel_raul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.practicas.pmdm.pmdm_t4a8_granel_raul.model.Operator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private List<Operator> operatorList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init Components
        spinner = findViewById(R.id.sp1);
        operatorList = getOperatorsList();
        ArrayAdapter<Operator> adapter = null;

        if (null == operatorList) {
            operatorList = new ArrayList<>();
            Operator operator = new Operator();
            operator.setId(0);
            operator.setName("No existen datos para mostrar.");

            operatorList.add(operator);
        }
        adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, operatorList);
        spinner.setAdapter(adapter);
    }

    public List<Operator> getOperatorsList() {

        ArrayList<Operator> operatorsList = new ArrayList<>();
        operatorsList.add(new Operator(1, "sumar", "+"));
        operatorsList.add(new Operator(2, "restar", "-"));
        operatorsList.add(new Operator(3, "multiplicar", "*"));
        operatorsList.add(new Operator(4, "dividir", "/"));

        return operatorsList;
    }

}