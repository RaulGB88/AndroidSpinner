package com.practicas.pmdm.pmdm_t4a8_granel_raul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.practicas.pmdm.pmdm_t4a8_granel_raul.model.Operator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    ArrayAdapter<Operator> adapter = null;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private Button btnCalculate;
    private List<Operator> operatorList = null;
    private String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init Components
        init();
        spinner.setOnItemSelectedListener(this);

        // Get the Spinner element selected.
        item = getSelectedSpinnerItem(spinner);
    }

    public void init() {
        spinner = findViewById(R.id.sp1);
        operatorList = getOperatorsList();

        // Get EditText elements.
        et1 = (EditText) this.findViewById(R.id.et1);
        et2 = (EditText) this.findViewById(R.id.et2);
        et3 = (EditText) this.findViewById(R.id.et3);
        btnCalculate = (Button) this.findViewById(R.id.btnCalculate);

        adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, operatorList);
        spinner.setAdapter(adapter);

        if (operatorList == null) {
            operatorList = new ArrayList<>();
            Operator operator = new Operator();
            operator.setId(0);
            operator.setName("No existen datos para mostrar.");

            operatorList.add(operator);
        }
    }

    public String getSelectedSpinnerItem(Spinner spinner) {
        String item = "";
        item = spinner.getSelectedItem().toString();
        return item;
    }

    public Integer checkNumber(String number) {
        return Integer.parseInt(number);
    }

    public Integer operate(String num1, String num2, String item) {

        int result = 0;

        int number1 = 0;
        int number2 = 0;

        // Check and get the EditText Integers.
        if (et1 != null && !"".equalsIgnoreCase(et1.getText().toString())) {
            number1 = checkNumber(et1.getText().toString());
        }
        if (et2 != null && !"".equalsIgnoreCase(et2.getText().toString())) {
            number2 = checkNumber(et2.getText().toString());
        }

        if (et1 != null & et2 != null && !"".equalsIgnoreCase(et1.getText().toString()) && !"".equalsIgnoreCase(et2.getText().toString())
                && item != null & !"".equalsIgnoreCase(item)) {
            switch (item) {
                case "SUMAR":
                    result = number1 + number2;
                    break;
                case "RESTAR":
                    result = number1 - number2;
                    break;
                case "MULTIPLICAR":
                    result = number1 * number2;
                    break;
                case "DIVIDIR":
                    result = number1 / number2;
                    break;
            }
        }

        return result;
    }

    public List<Operator> getOperatorsList() {

        ArrayList<Operator> operatorsList = new ArrayList<>();
        operatorsList.add(new Operator(1, "SUMAR", "+"));
        operatorsList.add(new Operator(2, "RESTAR", "-"));
        operatorsList.add(new Operator(3, "MULTIPLICAR", "*"));
        operatorsList.add(new Operator(4, "DIVIDIR", "/"));

        return operatorsList;
    }

    public void buttonEvent(View view) {
        item = getSelectedSpinnerItem(spinner);
        String res = operate(et1.getText().toString(), et2.getText().toString(), item).toString();
        et3.setText(res);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}