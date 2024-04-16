package com.example.androidfinalproject.viewPager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.androidfinalproject.R;

public class CustomViewPagerAdapter extends FragmentStateAdapter {

    public CustomViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return MyWalletFragment.newInstance(R.drawable.carda);
            case 1:
                return MyWalletFragment.newInstance(R.drawable.cardb);
            case 2:
                return MyWalletFragment.newInstance(R.drawable.cardc);
            case 3:
                return MyWalletFragment.newInstance(R.drawable.cardd);
            case 4:
                return MyWalletFragment.newInstance(R.drawable.carde);
            default:
                return MyWalletFragment.newInstance(1);
        }

    }

    // Show 5 Cards
    @Override
    public int getItemCount() {
        return 5;
    }
}
