package com.bitgym.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bitgym.R;

public final class MainImageFragment extends BaseFragment {
	private int image;

    public static MainImageFragment newInstance(int image) {
        MainImageFragment fragment = new MainImageFragment();
        fragment.image = image;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.main_image_fragment, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.mainImageView);
        imageView.setImageResource(image);
        return view;
    }
}
