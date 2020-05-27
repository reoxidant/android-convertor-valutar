package com.example.conventor_valutar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int selectedElemSpinner1;
    int selectedElemSpinner2;

    float[][] spinnerItems =
            {
                    {1.0f, 0.014f, 0.013f, 0.38f, 0.1f},
                    {70.90f, 1.0f, 0.91f, 26.99f, 7.17f},
                    {77.90f, 1.10f, 1.0f, 29.62f, 7.88f},
                    {2.63f, 0.037f, 0.034f, 1.0f, 0.27f},
                    {9.89f, 0.14f, 0.13f, 3.76f, 1.0f}
            };
    String[] resultNames = {"RUB", "USD", "EUR", "UAH", "CNY"};
    private float result;

    public void clickButton(View view) {
        Log.i("click", "button pressed!");

        float number = spinnerItems[selectedElemSpinner1][selectedElemSpinner2];
        String namesValutar = resultNames[selectedElemSpinner2];

        Log.i("result", "Our result is: " + number);

        //get value input
        EditText fieldVal = (EditText) findViewById(R.id.inputText);

        try {
            this.result = Float.valueOf(fieldVal.getText().toString()) * number;
        } catch (NumberFormatException e2) {
            System.out.println("Error get data input");
        }

        Toast.makeText(MainActivity.this, "Результат: " + String.format("%.2f", this.result) + " " + namesValutar, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] valutar = {"Рубль", "Доллар", "Евро", "Гривна", "Юань"};

        Spinner spinner = (Spinner) findViewById(R.id.valutar);
        Spinner spinner2 = (Spinner) findViewById(R.id.valutar2);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valutar);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Log.i("spinner 1", "Element " + id);
                selectedElemSpinner1 = (int) id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                Log.i("Message", "Nothing is selected");
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Log.i("spinner 2", "Element " + id);
                selectedElemSpinner2 = (int) id;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                Log.i("Message", "Nothing is selected");
            }
        });
    }
}