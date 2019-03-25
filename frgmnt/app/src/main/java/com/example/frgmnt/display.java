package com.example.frgmnt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

public class display extends AppCompatActivity{


    TextView nameofcan =(TextView)findViewById(R.id.candidatename);
    TextView ageofcan = (TextView)findViewById(R.id.candidateage);
    TextView educationofcan = (TextView)findViewById(R.id.candidateedu);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaypage);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        String name = bundle.getString("name");
        String age = bundle.getString("age");
        String education = bundle.getString("education");
        nameofcan.setText(name);
        ageofcan.setText(age);
        educationofcan.setText(education);

    }

}
