package edu.hackeru.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etShout;
    private Button btnShout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etShout = (EditText) findViewById(R.id.etShout);
        btnShout = (Button) findViewById(R.id.btnShout);

        //btnShout.setText(R.string.hello);
        btnShout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, etShout.getText().toString().toUpperCase(), Toast.LENGTH_SHORT).show();
    }
}
