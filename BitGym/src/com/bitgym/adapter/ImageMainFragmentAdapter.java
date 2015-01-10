package com.bitgym.adapter;

import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bitgym.R;
import com.bitgym.ui.fragments.MainImageFragment;

public class ImageMainFragmentAdapter extends FragmentPagerAdapter {

	private final int[] CONTENT = new int[] { R.drawable.bk_image01,
			R.drawable.bk_image02, R.drawable.bk_image03 };

	public ImageMainFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public int getCount() {
		return CONTENT.length;
	}

	@Override
	public Fragment getItem(int position) {
		return MainImageFragment.newInstance(CONTENT[position % CONTENT.length]);
	}
	
	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
	    if (observer != null) {
	        super.unregisterDataSetObserver(observer);
	    }
	}
}