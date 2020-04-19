package com.example.detikcomclone.adapter;

import com.example.detikcomclone.ui.categories.FragmentBusinness;
import com.example.detikcomclone.ui.categories.FragmentEntertainment;
import com.example.detikcomclone.ui.categories.FragmentGeneral;
import com.example.detikcomclone.ui.categories.FragmentHealth;
import com.example.detikcomclone.ui.categories.FragmentScience;
import com.example.detikcomclone.ui.categories.FragmentSports;
import com.example.detikcomclone.ui.categories.FragmentTechnology;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabsAdapterCategory extends FragmentStatePagerAdapter {
    int numbOfTabs;


    public TabsAdapterCategory(@NonNull FragmentManager fm, int numbOfTabs) {
        super(fm);
        this.numbOfTabs = numbOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentBusinness businness = new FragmentBusinness();
                return businness;
            case 1:
                FragmentEntertainment entertainment = new FragmentEntertainment();
                return entertainment;
            case 2:
                FragmentGeneral general  = new FragmentGeneral();
                return general;
            case 3:
                FragmentHealth health = new FragmentHealth();
                return health;
            case 4:
                FragmentScience science = new FragmentScience();
                return science;
            case 5:
                FragmentSports sports = new FragmentSports();
                return sports;
            case 6:
                FragmentTechnology technology = new FragmentTechnology();
                return technology;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numbOfTabs;
    }
}
