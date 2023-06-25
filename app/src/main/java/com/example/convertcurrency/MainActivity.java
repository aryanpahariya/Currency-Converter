package com.example.convertcurrency;

import static com.example.convertcurrency.R.id.spinner1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btn;
    EditText edt;

    TextView txt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        btn = (Button) findViewById(R.id.button1);
        edt = (EditText) findViewById(R.id.text1);
        txt = (TextView) findViewById(R.id.textview2);

        String[] Currency = {"Inr", "Euro", "Yen", "Dinar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Currency);
        spinner.setAdapter(adapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double total;
                Double amount = Double.parseDouble(edt.getText().toString());

                if(spinner.getSelectedItem().toString() == "Inr"){
                    total = amount * 82;
                    txt.setText(total.toString() + " inr");
                }

                if(spinner.getSelectedItem().toString() == "Euro"){
                    total = amount * 0.91;
                    txt.setText(total.toString() + " Euro");
                }

                if(spinner.getSelectedItem().toString() == "Yen"){
                    total = amount * 144 ;
                    txt.setText(total.toString() + " yen");
                }

                if(spinner.getSelectedItem().toString() == "Dinar"){
                    total = amount * 0.31;
                    txt.setText(total.toString() + " Dinar");
                }
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
