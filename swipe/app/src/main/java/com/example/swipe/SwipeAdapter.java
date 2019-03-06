package com.example.swipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SwipeAdapter extends FragmentStatePagerAdapter   {

    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment pageFragment = new FragmentPage();
        Bundle bundle = new Bundle();

        switch (i%7){
            case 0:
                bundle.putInt("image",R.drawable.modi);
                bundle.putInt("logo",R.drawable.bjp);
                bundle.putString("candidatename","Narendra modi");
                bundle.putString("partyname","BJP");
                bundle.putString("place","Alahabad");
                break;

            case 1:
                bundle.putInt("image",R.drawable.rahul);
                bundle.putInt("logo",R.drawable.congress);
                bundle.putString("candidatename","Rahul Gandhi");
                bundle.putString("partyname","Congress");
                bundle.putString("place","Amethi");
                break;

            case 2:
                bundle.putInt("image",R.drawable.kejrival);
                bundle.putInt("logo",R.drawable.aap);
                bundle.putString("candidatename","Arvind kejriwal");
                bundle.putString("partyname","AAP");
                bundle.putString("place","Delhi");
                break;

            case 3:
                bundle.putInt("image",R.drawable.uddhav);
                bundle.putInt("logo",R.drawable.shivsena);
                bundle.putString("candidatename","Uddhav Thackrey");
                bundle.putString("partyname","Shivsena");
                bundle.putString("place","Mumbai");
                break;

            case 4:
                bundle.putInt("image",R.drawable.akhilesh);
                bundle.putInt("logo",R.drawable.akhileshparty);
                bundle.putString("candidatename","Akhilesh yadav");
                bundle.putString("partyname","Samajvadi party");
                bundle.putString("place","Kannauj");
                break;

            case 5:
                bundle.putInt("image",R.drawable.mayavati);
                bundle.putInt("logo",R.drawable.mayavatiparty);
                bundle.putString("candidatename","Mayavati");
                bundle.putString("partyname","BSP");
                bundle.putString("place","UP");
                break;

            case 6:
                bundle.putInt("image",R.drawable.mamtaban);
                bundle.putInt("logo",R.drawable.mamta);
                bundle.putString("candidatename","Mamta banarjee");
                bundle.putString("partyname","AITCP");
                bundle.putString("place","Kolkatta");
                break;
        }
        pageFragment.setArguments(bundle);
        return pageFragment;
    }

    @Override
    public int getCount() {
        return 9999;
    }
}
