package com.example.androidfinalproject.viewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.androidfinalproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyWalletFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyWalletFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final int ARG_PARAM1 = 1;

    // TODO: Rename and change types of parameters
    private int mParam1;

    public MyWalletFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyWalletFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyWalletFragment newInstance(int param2) {
        MyWalletFragment fragment = new MyWalletFragment();
        Bundle args = new Bundle();
        args.putInt(String.valueOf(ARG_PARAM1), param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(String.valueOf(ARG_PARAM1));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_wallet, container, false);
        ImageView imageView = view.findViewById(R.id.imageView_credit);
        if(mParam1 != 0)
            imageView.setImageResource(mParam1);
        return view;
    }
}