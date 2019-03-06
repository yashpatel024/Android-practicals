package com.example.recyclerviewsimple;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private Context CListAdapter;
    private List<candidates> candidateList;

    public ListAdapter(Context CListAdapter, List<candidates> candidateList) {
        this.CListAdapter = CListAdapter;
        this.candidateList = candidateList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(CListAdapter);
        View view = inflater.inflate(R.layout.rowentry, null);
        ListViewHolder listholder = new ListViewHolder(view);
        return listholder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder listViewHolder, final int i) {
        candidates candidate = candidateList.get(i);

        listViewHolder.candidatename.setText(candidate.getCandidatename());
        listViewHolder.party.setText(candidate.getParty());
        listViewHolder.candidate.setImageDrawable(CListAdapter.getResources().getDrawable(candidate.getCandidate()));
        listViewHolder.b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0){
                    Intent i1 = new Intent(CListAdapter, modipfl.class);
                    CListAdapter.startActivity(i1);
                }else if(i ==1){
                    Intent i1=new Intent(CListAdapter,rahulpfl.class);
                    CListAdapter.startActivity(i1);
                }else if(i==2){
                    Intent i1=new Intent(CListAdapter,kejriwalpfl.class);
                    CListAdapter.startActivity(i1);
                }else if(i==3){
                    Intent i1=new Intent(CListAdapter,uddhavpfl.class);
                    CListAdapter.startActivity(i1);
                }else if(i==4){
                    Intent i1=new Intent(CListAdapter,mamtapfl.class);
                    CListAdapter.startActivity(i1);
                }else if(i==5){
                    Intent i1=new Intent(CListAdapter,mayavatipfl.class);
                    CListAdapter.startActivity(i1);
                }else if(i==6){
                    Intent i1=new Intent(CListAdapter,akhileshpfl.class);
                    CListAdapter.startActivity(i1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return candidateList.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder{

        ImageView candidate;
        TextView candidatename, party;
        Button b;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            candidate = itemView.findViewById(R.id.candidate);
            candidatename = itemView.findViewById(R.id.candidatename);
            party = itemView.findViewById(R.id.partyname);
            b=itemView.findViewById(R.id.detailbutton);

        }
    }
}
