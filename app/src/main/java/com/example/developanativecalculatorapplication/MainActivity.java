package com.example.developanativecalculatorapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private double var1, var2;
    private EditText textInput1, textInput2;
    private TextView result;
    private boolean isException = false;
    private Button add, sub, mul, div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInput1 = findViewById(R.id.input1);
        textInput2 = findViewById(R.id.input2);
        result = findViewById(R.id.result);
        add = findViewById(R.id.btnAdd);
        sub = findViewById(R.id.btnSub);
        mul = findViewById(R.id.btnMul);
        div = findViewById(R.id.btnDiv);
        clearColor();
    }
    public void onClickAdd(View view) {
        getData();
        if (!isException) {
            result.setText("" + (var1 + var2));
            add.setBackgroundColor(Color.GREEN);
        } else add.setBackgroundColor(Color.RED);
    }
    public void onClickSub(View view) {
        getData();
        if (!isException) {
            result.setText("" + (var1 - var2));
            sub.setBackgroundColor(Color.GREEN);
        } else sub.setBackgroundColor(Color.RED);
    }
    public void onClickMul(View view) {
        getData();
        if (!isException) {
            result.setText("" + (var1 * var2));
            mul.setBackgroundColor(Color.GREEN);
        } else mul.setBackgroundColor(Color.RED);
    }
    public void onClickDiv(View view) {
        getData();
        if (!isException) {
            if (var2 == 0 || var2 == -0) {
                isException = true;
                result.setText("");
                div.setBackgroundColor(Color.RED);
                Toast.makeText(this, "Please enter a Positive or Negitive Dividend",
                        Toast.LENGTH_LONG).show();
            } else {
                result.setText("" + (var1 / var2));
                div.setBackgroundColor(Color.GREEN);
            }
        } else div.setBackgroundColor(Color.RED);
    }
    private void getData() {
        clearColor();
        try {
            var1 = Double.valueOf(textInput1.getText().toString());
            var2 = Double.valueOf(textInput2.getText().toString());
            isException = false;
        } catch (java.lang.NumberFormatException e) {
            isException = true;
            Toast.makeText(this, "Please Enter both input fields.",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            isException = true;
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        if (isException) result.setText("");
    }
    private void clearColor() {
        add.setBackgroundColor(Color.DKGRAY);
        mul.setBackgroundColor(Color.DKGRAY);
        sub.setBackgroundColor(Color.DKGRAY);
        div.setBackgroundColor(Color.DKGRAY);
    }
}