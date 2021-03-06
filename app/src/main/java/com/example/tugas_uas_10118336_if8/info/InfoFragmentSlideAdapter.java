package com.example.tugas_uas_10118336_if8.info;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class InfoFragmentSlideAdapter extends FragmentStatePagerAdapter {
    // 9 Agustus 2021 - 10118369 - Josep Victor Rajadoli - IF 9

    private List<Fragment> fragmentList;
    public InfoFragmentSlideAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {

        return fragmentList.size();
    }
}
