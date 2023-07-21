package com.harsha.new_calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {

    public double currentResult = 0.0;

    Button Button_0, Button_1, Button_2, Button_dot, Button_3, Button_4, Button_5, Button_6, Button_7, Button_8, Button_9, Button_add, Button_minus, Button_div, Button_equal, Button_mul, Button_clear, Button_all;
    TextView edr, edw;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button_0 = findViewById(R.id.Button_0);
        Button_1 = findViewById(R.id.Button_1);
        Button_2 = findViewById(R.id.Button_2);
        Button_3 = findViewById(R.id.Button_3);
        Button_4 = findViewById(R.id.Button_4);
        Button_5 = findViewById(R.id.Button_5);
        Button_6 = findViewById(R.id.Button_6);
        Button_7 = findViewById(R.id.Button_7);
        Button_8 = findViewById(R.id.Button_8);
        Button_9 = findViewById(R.id.Button_9);
        Button_add = findViewById(R.id.Button_add);
        Button_div = findViewById(R.id.Button_div);
        Button_mul = findViewById(R.id.Button_mul);
        Button_minus = findViewById(R.id.Button_minus);
        Button_equal = findViewById(R.id.Button_equal);
        edr = findViewById(R.id.edittext_result);
        edw = findViewById(R.id.edittext_work);
        Button_clear = findViewById(R.id.Button_Clear);
        Button_all = findViewById(R.id.Button_Clear_all);
        Button_dot = findViewById(R.id.Button_dot);


        Button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.append("0");


            }
        });

        Button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.append("1");

            }
        });

        Button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.append("2");

            }
        });

        Button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.append("3");
            }
        });

        Button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.append("4");
            }
        });

        Button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.append("5");
            }
        });

        Button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.append("6");
            }
        });

        Button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.append("7");
            }
        });

        Button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.append("8");
            }
        });

        Button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.append("9");

            }
        });

        Button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.append("+");
            }
        });

        Button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.append("-");
            }
        });
        Button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.append("/");
            }
        });
        Button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.append("*");
            }
        });
        Button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dataToCalculate = edw.getText().toString();
                String finalResult = getResult(dataToCalculate);
                edr.setText(finalResult);

            }
        });

        Button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = edw.getText().toString();
                data = data.substring(0, data.length() - 1);
                edw.setText(data);
            }
        });
        Button_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.setText("");
                edr.setText("0");

            }
        });

        Button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edw.append(".");

            }
        });


    }


    String getResult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            return finalResult;
        } catch (Exception e) {
            return "err";
        }


    }


}