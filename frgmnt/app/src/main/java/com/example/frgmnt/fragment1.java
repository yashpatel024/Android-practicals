package com.example.frgmnt;

import android.content.Context;
import android.os.Bundle;
import android.provider.MediaStore;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class fragment1 extends Fragment {
    @Nullable

    private interfaceA listenerA;

    public interface interfaceA{
        void passDataA(String candidname, String age, String sex, String education);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment1,container,false);
        Button submitbtn1=(Button)view.findViewById(R.id.submitbtn1);
        final TextInputEditText name=(TextInputEditText)view.findViewById(R.id.inputtextname);
        final TextInputEditText age=(TextInputEditText)view.findViewById(R.id.inputtextage);
        final RadioGroup sexgroup=(RadioGroup)view.findViewById(R.id.radiobtn);
        final TextInputEditText education=(TextInputEditText)view.findViewById(R.id.inputtesteducation);

        submitbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedid=sexgroup.getCheckedRadioButtonId();
                RadioButton checkedbtn =(RadioButton)view.findViewById(selectedid);
                listenerA.passDataA(name.getText().toString(),age.getText().toString(),checkedbtn.getText().toString(),education.getText().toString());
            }
        });

        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof interfaceA)
            listenerA = (interfaceA) context;
        else throw new RuntimeException(context.toString()+"must implement Fragment 1 listener");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listenerA = null;
    }
}
