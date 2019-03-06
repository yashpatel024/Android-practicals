package com.example.frgmnt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2,container,false);
        Spinner spinner=(Spinner)view.findViewById(R.id.droplistparty);

        Button submitbtn2=(Button)view.findViewById(R.id.submitbtn2);
        ImageView partyimage=(ImageView)view.findViewById(R.id.partylogo);
        String partyname = String.valueOf(spinner.getSelectedItem());
        if(partyname == "BJP"){
            partyimage.setImageResource(R.drawable.bjp);
        }else if(partyname == "INC"){
            partyimage.setImageResource(R.drawable.congress);
        }else if(partyname == "AAP"){
            partyimage.setImageResource(R.drawable.aap);
        }

        Button buttonload=(Button)view.findViewById(R.id.buttonLoadPicture);
        /*buttonload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });*/
        submitbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragment3 fragment3obj = new fragment3();
                fragmentTransaction.replace(R.id.fragmentlayout, fragment3obj);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

/*
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            // String picturePath contains the path of selected Image
        }*/
}
