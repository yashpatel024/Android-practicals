package com.example.yash.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class uddhavpfl extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uddhav);

        Button b1,b2;

        b1 = (Button)findViewById(R.id.prevbtn);
        b2 = (Button)findViewById(R.id.nextbtn);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(uddhavpfl.this,akhileshpfl.class );
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(uddhavpfl.this, kejriwalpfl.class);
                startActivity(i);
            }
        });
    }
}
