//Name - Ansh Agrawal
//Temperature Converter App which converts celsius to fahrenheit and viceversa
package com.example.converttemp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTemperature;
    private RadioGroup radioGroupFrom;
    private Button buttonConvert;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTemperature = findViewById(R.id.editTextTemperature);
        radioGroupFrom = findViewById(R.id.radioGroupFrom);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        String input = editTextTemperature.getText().toString().trim();
        if (input.isEmpty()) {
            textViewResult.setText("Please enter a temperature.");
            return;
        }

        double temperature = Double.parseDouble(input);
        int selectedRadioButtonId = radioGroupFrom.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

        if (selectedRadioButton == null) {
            textViewResult.setText("Please select a unit.");
            return;
        }

        double convertedTemperature;
        if (selectedRadioButton.getId() == R.id.radioButtonCelsius) {
            // Convert from Celsius to Fahrenheit
            convertedTemperature = (temperature * 9/5) + 32;
            textViewResult.setText(String.format("%.2f °F", convertedTemperature));
        } else {
            // Convert from Fahrenheit to Celsius
            convertedTemperature = (temperature - 32) * 5/9;
            textViewResult.setText(String.format("%.2f °C", convertedTemperature));
        }
    }
}
