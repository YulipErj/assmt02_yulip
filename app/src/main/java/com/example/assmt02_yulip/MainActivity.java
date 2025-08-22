package com.example.assmt02_yulip;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etFirstNumber, etSecondNumber, etResult;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hook up views
        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSecondNumber = findViewById(R.id.etSecondNumber);
        etResult = findViewById(R.id.etResult);

        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        // Basic click listeners (beginner-friendly, no lambdas)
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { calculate('+'); }
        });
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { calculate('-'); }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { calculate('*'); }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { calculate('/'); }
        });
    }

    private void calculate(char op) {
        String a = etFirstNumber.getText().toString().trim();
        String b = etSecondNumber.getText().toString().trim();

        if (a.isEmpty() || b.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double x, y;
        try {
            x = Double.parseDouble(a);
            y = Double.parseDouble(b);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
            return;
        }

        double ans = 0;
        switch (op) {
            case '+': ans = x + y; break;
            case '-': ans = x - y; break;
            case '*': ans = x * y; break;
            case '/':
                if (y == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                ans = x / y; break;
        }
        etResult.setText(String.valueOf(ans));
    }
}
