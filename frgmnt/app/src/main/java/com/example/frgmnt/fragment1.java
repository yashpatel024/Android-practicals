package com.example.frgmnt;

import android.content.Context;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
        void passDataA(Bundle bundle);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment1,container,false);
        Button submitbtn1=(Button)view.findViewById(R.id.submitbtn1);

        submitbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView name=(TextView)view.findViewById(R.id.inputtextname);
                TextView age=(TextView)view.findViewById(R.id.inputtextage);
                RadioGroup sexgroup=(RadioGroup)view.findViewById(R.id.radiobtn);
                TextView education=(TextView)view.findViewById(R.id.inputtesteducation);

                String nameofcandidate = (String) name.getText();
                String ageofcandidate=(String)age.getText();
                String educationcandidate=(String)education.getText();

                int selectedid=sexgroup.getCheckedRadioButtonId();
                RadioButton checkedbtn =(RadioButton)view.findViewById(selectedid);
                String sexofcandidate= (String) checkedbtn.getText();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragment2 fragment2obj = new fragment2();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragmentlayout, fragment2obj);
                fragmentTransaction.commit();

                Bundle bundle= new Bundle();
                bundle.putString("name",nameofcandidate);
                bundle.putString("age",ageofcandidate);
                bundle.putString("sex",sexofcandidate);
                bundle.putString("education",educationcandidate);
                listenerA.passDataA(bundle);
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
