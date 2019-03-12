package com.example.firebasepract;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        final FirebaseAuth firebaseApp;
        FirebaseApp.initializeApp(this);
        firebaseApp = FirebaseAuth.getInstance();

        final EditText mail=(EditText)findViewById(R.id.username);
        final EditText pwd=(EditText)findViewById(R.id.password);
        final EditText number=(EditText)findViewById(R.id.number);
        Button signup=(Button)findViewById(R.id.submit);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mail.getText().toString().equals("") || pwd.getText().toString().equals("")||number.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Fill up the filed",Toast.LENGTH_SHORT);
                }else{
                    String usermail,password,usernumber;
                    usermail=mail.getText().toString();
                    password=pwd.getText().toString();
                    //usernumber=number.getText().toString();
                    firebaseApp.createUserWithEmailAndPassword(usermail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Successfully signup",Toast.LENGTH_SHORT);
                                finish();
                            }
                        }
                    });

                }
            }
        });


    }
}
