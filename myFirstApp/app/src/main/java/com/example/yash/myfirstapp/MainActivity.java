package com.example.yash.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String candidate[] = {"Narendra Modi","Rahul Gandhi", "Arvind Kejrival", "Uddhav Thackeray", "Akhilesh Yadav", "Mamta Benerjee", "Mayavati"};
    String party[] = {"Bhartiya janta party","Indian national congress", "Aam aadmi party", "Shivsena", "Samajwadi party", "All india trinamool congress", "Bahujan samaj party"};
    int image[] = {R.drawable.modi_l,R.drawable.rahul_l,R.drawable.kejriwal_l,R.drawable.uddhav_l,R.drawable.akhilesh_l, R.drawable.mamtaban_l, R.drawable.mayavati_l};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.candidatelist);

        MyAdapter adapter = new MyAdapter(this, candidate, image, party);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent i = new Intent(MainActivity.this, modipfl.class);
                    startActivity(i);
                }
                else if(position == 1){
                    Intent i = new Intent(MainActivity.this, rahulpfl.class);
                    startActivity(i);
                }
                else if(position == 2){
                    Intent i = new Intent(MainActivity.this, kejriwalpfl.class);
                    startActivity(i);
                }
                else if(position == 3){
                    Intent i = new Intent(MainActivity.this, uddhavpfl.class);
                    startActivity(i);
                }
                else if(position == 4){
                    Intent i = new Intent(MainActivity.this, akhileshpfl.class);
                    startActivity(i);
                }
                else if(position == 5) {
                    Intent i = new Intent(MainActivity.this, mamtapfl.class);
                    startActivity(i);
                }else{
                    Intent i = new Intent(MainActivity.this, mayavatipfl.class);
                    startActivity(i);
                }
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String candidates[];
        String parties[];
        int images[];

        MyAdapter(Context c, String[] candidate, int[] image, String[] party){
            super(c, R.layout.entryrow, R.id.candidatename, candidate);
            this.context = c;
            this.images = image;
            this.candidates = candidate;
            this.parties = party;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View entryrow = layoutInflater.inflate(R.layout.entryrow, parent,false);

            ImageView images = entryrow.findViewById(R.id.candidateimg);
            TextView candidate = entryrow.findViewById(R.id.candidatename);
            TextView party = entryrow.findViewById(R.id.partyname);

            images.setImageResource(image[position]);
            candidate.setText(candidates[position]);
            party.setText(parties[position]);

            return entryrow;
        }
    }
}
