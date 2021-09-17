package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText etcode;
    Button btGen,btScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etcode=findViewById(R.id.etCode);
        btGen=findViewById(R.id.btnCreate);
        btScan=findViewById(R.id.btnScan);

        btGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=etcode.getText().toString();
                Intent ii =new Intent(getApplicationContext(),QRCodeGen.class);
                ii.putExtra("mycode",message);
                startActivity(ii);
            }
        });

        btScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii =new Intent(getApplicationContext(),QRCodeScan.class);

                startActivity(ii);

            }
        });
    }

}