package com.example.frgmnt;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class activity2 extends AppCompatActivity implements fragment1.interfaceA, fragment2.interfaceB, fragment3.interfaceC{

    fragment1 f1;
    fragment2 f2;
    fragment3 f3;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Bundle bundle= new Bundle();
    String name, sex, education;
    String partyname;
    String history, pastwin, ministry;
    String age;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2xml);
        f1 = new fragment1();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentlayout,f1).commit();
    }

    @Override
    public void passDataA(String candidname, String  age, String sex, String education) {
        this.name=candidname;
        this.age=age;
        this.sex=sex;
        this.education=education;
        if(name == "" || sex == "" || education == ""){
            Toast.makeText(this,"Please enter complete information",Toast.LENGTH_SHORT).show();
        }else{
            f2=new fragment2();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentlayout,f2).commit();
        }
    }

    @Override
    public void passDataB(String partyname) {
        this.partyname = partyname;
        if(partyname == ""){
            Toast.makeText(this,"Please enter complete information",Toast.LENGTH_SHORT).show();
        }else{
            f3 = new fragment3();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentlayout,f3).commit();
        }
    }


    @Override
    public void passDataC(String history, String pastwin, String ministry) {
        this.history = history;
        this.pastwin = pastwin;
        this.ministry = ministry;

        bundle.putString("name",name);
        bundle.putString("sex",sex);
        bundle.putString("age",age);
        bundle.putString("education",education);
        bundle.putString("partyname",partyname);
        bundle.putString("history",history);
        bundle.putString("pastwin",pastwin);
        bundle.putString("ministry",ministry);

        if(history == "" || pastwin == "" || ministry == ""){
            Toast.makeText(this,"Please enter complete information",Toast.LENGTH_SHORT).show();
        }else{
            Intent i =new Intent(activity2.this, display.class);
            i.putExtras(bundle);
            startActivity(i);

        }
    }

}
