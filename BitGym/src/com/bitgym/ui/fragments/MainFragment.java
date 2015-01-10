
package com.bitgym.ui.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bitgym.R;
import com.bitgym.adapter.ImageMainFragmentAdapter;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

public class MainFragment extends BaseFragment implements OnClickListener {

	private Button m_btnInstructor;
    private Button m_btnPersonalTraining;
    private Button m_btnSelectWorkout;
    private Button m_btnQuickStart;
	
    ImageMainFragmentAdapter mAdapter;
    ViewPager mPager;
    PageIndicator mIndicator;
    TextView mExplanation;
    ImageButton m_ibBack = null;

    public static final String TAG = "detailsFragment";
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	View view = inflater.inflate(R.layout.main_fragment, container, false);
    	
    	m_btnInstructor = (Button)view.findViewById(R.id.btnInstructor);
    	m_btnPersonalTraining = (Button)view.findViewById(R.id.btnPersonalTraining);
    	m_btnSelectWorkout = (Button)view.findViewById(R.id.btnSelectWorkout);
    	m_btnQuickStart = (Button)view.findViewById(R.id.btnQuickStart);
    	
    	Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/futura-condensed-extrabold.ttf");
    	m_btnInstructor.setTypeface(tf, Typeface.BOLD);
    	m_btnPersonalTraining.setTypeface(tf, Typeface.BOLD);
    	m_btnSelectWorkout.setTypeface(tf, Typeface.BOLD);
    	m_btnQuickStart.setTypeface(tf, Typeface.BOLD);
    	
        mAdapter = new ImageMainFragmentAdapter(getChildFragmentManager());

        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (CirclePageIndicator) view.findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);

        ((CirclePageIndicator) mIndicator).setFillColor(getResources().getColor(R.color.red_asia));
        ((CirclePageIndicator) mIndicator).setPageColor(getResources().getColor(R.color.white));
        ((CirclePageIndicator) mIndicator).bringToFront();
        ((CirclePageIndicator) mIndicator).setStrokeWidth(0);
        final float density1 = getResources().getDisplayMetrics().density;
        ((CirclePageIndicator) mIndicator).setRadius(4 * density1);
        

        mIndicator.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int page) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        showSupportActionBar(true);        
        ((Button) view.findViewById(R.id.btnSelectWorkout)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.btnQuickStart)).setOnClickListener(this);
        
        return view;
    }
	
    
}
