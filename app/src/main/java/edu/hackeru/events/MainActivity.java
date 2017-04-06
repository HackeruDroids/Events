package edu.hackeru.events;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    //1) controller properties:
    RadioGroup rgTemperature;
    RadioButton rbCelcius;
    RadioButton rbFahrenheit;
    Button btnCalc;
    EditText etTemperature;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgTemperature = (RadioGroup) findViewById(R.id.rgTemperature);
        rbCelcius = (RadioButton) findViewById(R.id.rbCelcius);
        rbFahrenheit = (RadioButton) findViewById(R.id.rbFahrenheit);
        etTemperature = (EditText) findViewById(R.id.etTemperature);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(this);
        rgTemperature.setOnCheckedChangeListener(this);
    }


    @Override
    public void onClick(View view) {
        calc();
    }

    private void calc() {
        try {
            //1) get the text from the editTemp
            Editable text = etTemperature.getText();

            //2) convert the text to a double variable (Double.valueOf()
            Double temp = Double.valueOf(text.toString());

            //3) decide about the formula (if rbCelcius -> toCelcius, else toFahrenheit Formula
            Double result = 0.0;
            if (rbCelcius.isChecked()) {
                //from fahrenheit to Celsius
                //T(°C) = (T(°F) - 32)*5/9
                result = (temp - 32) * 5.0 / 9;
            } else if (rbFahrenheit.isChecked()) {
                //from Celsius  to  fahrenheit
                //T(°F) = T(°C) × 9/5 + 32
                result = temp * 9.0/5 + 32;
            }

            //3.1) do the conversion of 2 using the formula from 3
            //4) set the text on the tvResult
            tvResult.setText(result.toString());
        } catch (NumberFormatException e) {
            etTemperature.setError("Not a number...");
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        calc();
    }
}
