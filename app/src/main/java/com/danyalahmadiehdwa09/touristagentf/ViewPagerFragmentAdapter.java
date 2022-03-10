package com.danyalahmadiehdwa09.touristagentf;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ViewPagerFragmentAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> listFragment = new ArrayList<>();

    public ViewPagerFragmentAdapter(FragmentActivity fa, ArrayList<Fragment> list) {
        super(fa);
        listFragment = list;
    }

    @NotNull
    @Override
    public Fragment createFragment(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

