package com.example.frgmnt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class display extends AppCompatActivity implements fragment1.interfaceA{

    TextView name = (TextView)findViewById(R.id.candidatename);
    TextView age = (TextView)findViewById(R.id.candidateage);
    TextView education = (TextView)findViewById(R.id.candidateedu);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaypage);
    }

    @Override
    public void passDataA(Bundle bundle) {
        bundle=this.getIntent().getExtras();
        name.setText(bundle.getString("name"));
        age.setText(bundle.getString("age"));
        education.setText(bundle.getString("education"));
    }
}
