package com.example.detikcomclone.adapter;

import com.example.detikcomclone.ui.categories.FragmentBusinness;
import com.example.detikcomclone.ui.categories.FragmentEntertainment;
import com.example.detikcomclone.ui.categories.FragmentGeneral;
import com.example.detikcomclone.ui.categories.FragmentHealth;
import com.example.detikcomclone.ui.categories.FragmentScience;
import com.example.detikcomclone.ui.categories.FragmentSports;
import com.example.detikcomclone.ui.categories.FragmentTechnology;
import com.example.detikcomclone.ui.category_all_source.Fragment_Source_Businness;
import com.example.detikcomclone.ui.category_all_source.Fragment_Source_Entertainment;
import com.example.detikcomclone.ui.category_all_source.Fragment_Source_General;
import com.example.detikcomclone.ui.category_all_source.Fragment_Source_Health;
import com.example.detikcomclone.ui.category_all_source.Fragment_Source_Science;
import com.example.detikcomclone.ui.category_all_source.Fragment_Source_Sports;
import com.example.detikcomclone.ui.category_all_source.Fragment_Source_Technology;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Created by Harri Pratomo
 * harrypratomo135@gmail.com
 */
public class TabAdapterAllSource  extends FragmentStatePagerAdapter {
    int numbOfTabs;


    public TabAdapterAllSource(@NonNull FragmentManager fm, int numbOfTabs) {
        super(fm);
        this.numbOfTabs = numbOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Fragment_Source_Businness businness = new Fragment_Source_Businness();
                return businness;
            case 1:
                Fragment_Source_Entertainment entertainment = new Fragment_Source_Entertainment();
                return entertainment;
            case 2:
                Fragment_Source_General general  = new Fragment_Source_General();
                return general;
            case 3:
                Fragment_Source_Health health = new Fragment_Source_Health();
                return health;
            case 4:
                Fragment_Source_Science science = new Fragment_Source_Science();
                return science;
            case 5:
                Fragment_Source_Sports sports = new Fragment_Source_Sports();
                return sports;
            case 6:
                Fragment_Source_Technology technology = new Fragment_Source_Technology();
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

