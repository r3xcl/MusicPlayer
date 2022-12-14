package com.r3xcl.musicplayer.ui.home;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.r3xcl.musicplayer.Fragment1;
import com.r3xcl.musicplayer.Fragment2;
import com.r3xcl.musicplayer.Fragment3;
import com.r3xcl.musicplayer.R;
import com.r3xcl.musicplayer.VPAdapter;
import com.r3xcl.musicplayer.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;


    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


         TabLayout tabLayout;
         ViewPager viewPager;


        tabLayout = root.findViewById(R.id.tabLayout);
        viewPager = root.findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addfragment(new Fragment1(), "ПЕСНИ");
        vpAdapter.addfragment(new Fragment2(), "ПЛЕЙЛИСТЫ");
        vpAdapter.addfragment(new Fragment3(), "ПАПКИ");
        vpAdapter.addfragment(new Fragment3(), "АЛЬБОМЫ");
        vpAdapter.addfragment(new Fragment3(), "АРТИСТЫ");
        vpAdapter.addfragment(new Fragment3(), "ЖАНРЫ");

        viewPager.setAdapter(vpAdapter);

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}