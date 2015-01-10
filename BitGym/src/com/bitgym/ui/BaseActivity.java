
package com.bitgym.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.bitgym.R;
import com.navdrawer.SimpleSideDrawer;

public class BaseActivity extends SherlockFragmentActivity implements OnClickListener {
    @SuppressWarnings("unused")
	private boolean isActionBarVisible = false;
    private ScrollView drawer;
    ImageView imBookNow;
    private String titleActivity = null;
    private static int currentMenuSelected;
    
    private SimpleSideDrawer slide_me;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.action_bar_custom_layout);
        }

    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = null;
        switch (v.getId()) {
        case R.id.rlLeftMenuLoginMenu:
        	clearStatus();
            //get infomation account and set to left menu
        	getAccountInfo();
        	currentMenuSelected = v.getId();
            break;
        case R.id.rlLeftMenuAppDemoLeftMenu:
        	clearStatus();
        	gotoAppDemo();
        	currentMenuSelected = v.getId();
            break;
        default:
            intent = null;
            break;
        }
	}
	private void clearStatus(){
		switch (this.currentMenuSelected) {
        case R.id.rlLeftMenuLoginMenu:
        	clearStatusLoginMenu();
            break;
        case R.id.rlLeftMenuAppDemoLeftMenu:
        	clearStatusAppDemoMenu();
            break;
        default:
        	clearStatusLoginMenu();
            break;
        }
	}
	private void clearStatusAppDemoMenu() {
		Drawable myIcon = getResources().getDrawable( R.drawable.left_menu_appdemo_icon ); 
		ColorFilter filter = new LightingColorFilter( getResources().getColor(R.color.gray), getResources().getColor(R.color.gray) ); 
		myIcon.setColorFilter(filter); 
		((ImageView)findViewById(R.id.imgAppDemoLeftMenu)).setImageDrawable(myIcon);
		((TextView)findViewById(R.id.tvAppDemoLeftMenu)).setTextColor(getResources().getColor(R.color.gray));
	}
	
	private void clearStatusLoginMenu(){
		Drawable myIcon = getResources().getDrawable( R.drawable.left_menu_avatar ); 
		ColorFilter filter = new LightingColorFilter( getResources().getColor(R.color.gray), getResources().getColor(R.color.gray) ); 
		myIcon.setColorFilter(filter); 
		((ImageView)findViewById(R.id.imgLoginLeftMenu)).setImageDrawable(myIcon);
		((TextView)findViewById(R.id.tvLoginLeftMenu)).setTextColor(getResources().getColor(R.color.gray));
		((TextView)findViewById(R.id.tvAccountNameLeftMenu)).setTextColor(getResources().getColor(R.color.gray));
		((TextView)findViewById(R.id.tvAccountNameLeftMenu)).setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_left_menu_around_gray_style));
	}
	
	private void getAccountInfo(){
		Drawable myIcon = getResources().getDrawable( R.drawable.left_menu_avatar ); 
		ColorFilter filter = new LightingColorFilter( getResources().getColor(R.color.white), getResources().getColor(R.color.white) ); 
		myIcon.setColorFilter(filter); 
		((ImageView)findViewById(R.id.imgLoginLeftMenu)).setImageDrawable(myIcon);
		((TextView)findViewById(R.id.tvAccountNameLeftMenu)).setVisibility(View.VISIBLE);
		((TextView)findViewById(R.id.tvAccountNameLeftMenu)).setText("HI STEVE");
		((TextView)findViewById(R.id.tvAccountNameLeftMenu)).setTextColor(getResources().getColor(R.color.white));
		((TextView)findViewById(R.id.tvAccountNameLeftMenu)).setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_left_menu_around_style));
		((TextView)findViewById(R.id.tvLoginLeftMenu)).setTextColor(getResources().getColor(R.color.white));
		((TextView)findViewById(R.id.tvLoginLeftMenu)).setText(getResources().getString(R.string.left_menu_account_menu));
	}
	
	private void gotoAppDemo(){
		Drawable myIcon = getResources().getDrawable( R.drawable.left_menu_appdemo_icon ); 
		ColorFilter filter = new LightingColorFilter( getResources().getColor(R.color.white), getResources().getColor(R.color.white) ); 
		myIcon.setColorFilter(filter); 
		((ImageView)findViewById(R.id.imgAppDemoLeftMenu)).setImageDrawable(myIcon);
		((TextView)findViewById(R.id.tvAppDemoLeftMenu)).setTextColor(getResources().getColor(R.color.white));
	}
	
	public void setActionbarTitle(String title) {
        TextView titleView = (TextView) findViewById(R.id.actionbarTitle);
        if (titleView != null) {
            titleView.setText(title);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
	
	public void setShowActionbar(boolean showActionBar) {
    	if (getSupportActionBar() != null) {
    		if (showActionBar){
        		getSupportActionBar().show();
        	}else{
        		getSupportActionBar().hide();
        	}
    	}
    }

    /**
     * Initialize drawer. Should be called after setContentView.
     */
    public void initializeDrawer(final String title) {
        drawer = (ScrollView) findViewById(R.id.svDrawer);
        
        slide_me = new SimpleSideDrawer(this);
        slide_me.setLeftBehindContentView(R.layout.drawer);
        
        final ImageView ibMenu = (ImageView) findViewById(R.id.ibMenu);

        ibMenu.setVisibility(View.VISIBLE);

        ibMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
            	slide_me.toggleLeftDrawer();

            }
        });
        
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/futura-condensed-extrabold.ttf");
        ((TextView)findViewById(R.id.tvHomeLeftMenu)).setTypeface(tf, Typeface.BOLD);
        ((TextView)findViewById(R.id.tvLoginLeftMenu)).setTypeface(tf, Typeface.BOLD);
        ((TextView)findViewById(R.id.tvAccountNameLeftMenu)).setTypeface(tf, Typeface.BOLD);
        ((TextView)findViewById(R.id.tvInstructorLeftMenu)).setTypeface(tf, Typeface.BOLD);
        ((TextView)findViewById(R.id.tvConnectBikeLeftMenu)).setTypeface(tf, Typeface.BOLD);
        ((TextView)findViewById(R.id.tvConnectBikeNumberLeftMenu)).setTypeface(tf, Typeface.BOLD);
        ((TextView)findViewById(R.id.tvWorkoutHistoryLeftMenu)).setTypeface(tf, Typeface.BOLD);
        ((TextView)findViewById(R.id.tvAppDemoLeftMenu)).setTypeface(tf, Typeface.BOLD);
        ((TextView)findViewById(R.id.tvSettingLeftMenu)).setTypeface(tf, Typeface.BOLD);
        
        findViewById(R.id.rlLeftMenuLoginMenu).setOnClickListener(this);
        findViewById(R.id.rlLeftMenuInstructorLeftMenu).setOnClickListener(this);
        findViewById(R.id.rlLeftMenuConnectBikeLeftMenu).setOnClickListener(this);
        findViewById(R.id.rlLeftMenuWorkoutHistoryLeftMenu).setOnClickListener(this);
        findViewById(R.id.rlLeftMenuAppDemoLeftMenu).setOnClickListener(this);
        findViewById(R.id.rlLeftMenuSettingLeftMenu).setOnClickListener(this);

    }
    
    public String getTitleActivity() {
		return titleActivity;
	}

	public void setTitleActivity(String titleActivity) {
		this.titleActivity = titleActivity;
	}

}
