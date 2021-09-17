package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGen extends Activity {

    ImageView iv;
    QRCodeWriter writer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_r_code_gen);

        iv=findViewById(R.id.iv);
        Intent ii=getIntent();
        String Code=ii.getStringExtra("mycode");

        writer=new QRCodeWriter();

        try{

            BitMatrix bn=writer.encode(Code, BarcodeFormat.QR_CODE,512,512);

            Bitmap img=Bitmap.createBitmap(512,512,Bitmap.Config.RGB_565);

            for(int i=0;i<512;i++)
            {
                for(int j=0;j<512;j++)
                {
                    if(bn.get(i,j)==false)
                    {
                        img.setPixel(i,j, Color.BLACK);
                    }
                    else
                    {
                        img.setPixel(i,j,Color.WHITE);
                    }
                }
            }
            iv.setImageBitmap(img);
        }


        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Error"+e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }
}