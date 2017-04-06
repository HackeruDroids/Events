package edu.hackeru.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etShout = (EditText) findViewById(R.id.etShout);
        Button btnShout = (Button) findViewById(R.id.btnShout);

        //btnShout.setText(R.string.hello);
        btnShout.setOnClickListener(this);
        etShout.setText("");

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Hello, Events", Toast.LENGTH_SHORT).show();
    }
}
