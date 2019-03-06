package com.example.swipe;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class FragmentPage extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view;
        Bundle bundle = getArguments();

        int image = bundle.getInt("image");
        int logo = bundle.getInt("logo");

        String candidatename = bundle.getString("candidatename");
        String partyname = bundle.getString("partyname");
        String place = bundle.getString("place");


        view = inflater.inflate(R.layout.fragmentpage,container,false);
        TextView cname=(TextView)view.findViewById(R.id.name);
        TextView pname=(TextView)view.findViewById(R.id.partyname);
        TextView placename=(TextView)view.findViewById(R.id.place);
        ImageView cimage = (ImageView)view.findViewById(R.id.candidateimg);
        ImageView clogo = (ImageView)view.findViewById(R.id.logo);

        cname.setText(candidatename);
        pname.setText(partyname);
        placename.setText(place);
        cimage.setImageResource(image);
        clogo.setImageResource(logo);

        return view;
        // return super.onCreateView(inflater, container, savedInstanceState);
    }
}
