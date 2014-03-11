package com.example.HelloAndroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    private EditText heightIn;
    private EditText weightIn;
    private Button btnCalcBMI;
    private double weight = 0;
    private double height = 0;
    private TextView resultBMI;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initializeApp();
    }

    private void initializeApp(){
        heightIn = (EditText)findViewById(R.id.heightInput);
        weightIn = (EditText)findViewById(R.id.weightInput);
        resultBMI = (TextView)findViewById(R.id.resultBMI);
        btnCalcBMI = (Button)findViewById(R.id.btnCalcBMI);
        btnCalcBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    public void calculateBMI(){
        Log.i("calculateBMI", "Button pressed");
        height = Double.parseDouble(heightIn.getText().toString());
        weight = Double.parseDouble(weightIn.getText().toString());

        Log.i("calculateBMI", String.valueOf(height));
        Log.i("calculateBMI", String.valueOf(weight));

        double bmi = weight/(height*height)*703.0;

        String result = String.format("%.2f", bmi);

        Log.i("calculateBMI", result);

        resultBMI.setText(result, TextView.BufferType.NORMAL);

    }


}
