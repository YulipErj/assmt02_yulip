package com.example.assmt02_yulip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input1, input2;
    Button addBtn, subBtn, mulBtn, divBtn;
    TextView resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect Java with XML IDs
        input1 = findViewById(R.id.editTextNumber1);
        input2 = findViewById(R.id.editTextNumber2);
        addBtn = findViewById(R.id.btnAdd);
        subBtn = findViewById(R.id.btnSub);
        mulBtn = findViewById(R.id.btnMul);
        divBtn = findViewById(R.id.btnDiv);
        resultTxt = findViewById(R.id.txtResult);

        // Add Button
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(input1.getText().toString());
                double num2 = Double.parseDouble(input2.getText().toString());
                double result = num1 + num2;
                resultTxt.setText("Result: " + result);
            }
        });

        // Subtract Button
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(input1.getText().toString());
                double num2 = Double.parseDouble(input2.getText().toString());
                double result = num1 - num2;
                resultTxt.setText("Result: " + result);
            }
        });

        // Multiply Button
        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(input1.getText().toString());
                double num2 = Double.parseDouble(input2.getText().toString());
                double result = num1 * num2;
                resultTxt.setText("Result: " + result);
            }
        });

        // Divide Button
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(input1.getText().toString());
                double num2 = Double.parseDouble(input2.getText().toString());
                if (num2 != 0) {
                    double result = num1 / num2;
                    resultTxt.setText("Result: " + result);
                } else {
                    resultTxt.setText("Error: Division by zero");
                }
            }
        });
    }
}
