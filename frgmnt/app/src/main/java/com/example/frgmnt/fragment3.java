package com.example.frgmnt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class fragment3 extends Fragment {

    private interfaceC listenerC;

    public interface interfaceC {
        void passDataC(String history, String pastwin, String ministry);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3,container,false);
        final TextInputEditText history = (TextInputEditText)view.findViewById(R.id.areatext);
        final TextInputEditText pastwin = (TextInputEditText) view.findViewById(R.id.pastwinlose);
        final TextInputEditText ministry =(TextInputEditText) view.findViewById(R.id.ministry);

        Button submitbtn3=(Button)view.findViewById(R.id.submitbtn3);
        submitbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerC.passDataC(history.getText().toString(), pastwin.getText().toString(), ministry.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof fragment3.interfaceC)
            listenerC = (fragment3.interfaceC) context;
        else throw new RuntimeException(context.toString()+"must implement Fragment 3 listener");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listenerC = null;
    }
}
