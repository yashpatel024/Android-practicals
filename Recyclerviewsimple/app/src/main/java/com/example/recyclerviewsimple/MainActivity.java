package com.example.recyclerviewsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView myRecyclerView;
    ArrayList<candidates> candidatesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        candidatesList = new ArrayList<>();

        myRecyclerView = (RecyclerView)findViewById(R.id.simplerecycler);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        candidatesList.add(
                new candidates(
                        "Narendra modi",
                        "Bhartiya janta party",
                        R.drawable.modi_l));
        candidatesList.add(
                new candidates(
                        "Rahul gandhi",
                        "Indian nation congress",
                        R.drawable.rahul_l));
        candidatesList.add(
                new candidates(
                        "Arvind Kejriwal",
                        "Aam aadmi party",
                        R.drawable.kejriwal_l));
        candidatesList.add(
                new candidates(
                        "Uddhav Thackeray  ",
                        "Shivsena",
                        R.drawable.uddhav_l));
        candidatesList.add(
                new candidates(
                        "Mamta benarjee",
                        "All india trinamool congress",
                        R.drawable.mamtaban_l));
        candidatesList.add(
                new candidates(
                        "Mayavati",
                        "Bahujan samaj party",
                        R.drawable.mayavati_l));
        candidatesList.add(
                new candidates(
                        "Akhilesh yadav",
                        "Samajwadi party",
                        R.drawable.akhilesh_l));

        ListAdapter adapter = new ListAdapter(this, candidatesList);
        myRecyclerView.setAdapter(adapter);

    }


}
