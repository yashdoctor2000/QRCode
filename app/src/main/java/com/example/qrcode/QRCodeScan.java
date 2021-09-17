 package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCodeScan extends Activity implements ZXingScannerView.ResultHandler{

    ZXingScannerView scanView;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_r_code_scan);

        scanView=new ZXingScannerView(getApplicationContext());
        setContentView(scanView);

        scanView.setResultHandler(this);
        scanView.startCamera();

        tv=findViewById(R.id.tv);

    }

    @Override
    protected void onPause()
    {
        super.onPause();
        scanView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult)
    {
        Toast.makeText(getApplicationContext(),rawResult.getText(),Toast.LENGTH_LONG).show();
      //  tv.setText(rawResult.getText());
    }
}