
package com.bitgym.ui.fragments;

import android.app.Activity;

import com.actionbarsherlock.app.SherlockFragment;
import com.bitgym.ui.BaseActivity;


public abstract class BaseFragment extends SherlockFragment  {
	@Override
	public void onStart() {
	      super.onStart();
//	      gaTracker.setContext(getActivity().getBaseContext());
//	      gaTracker.activityStart(getActivity());
	   }
	@Override
	public void onResume(){
		super.onResume();
	}
	 
	   @Override
	public void onStop() {
	      super.onStop();
//	      gaTracker.activityStop(getActivity());
	   }


    
    protected void setTitle (String title) {
    	
    	Activity act = getActivity(); 
    	if ( act != null && act instanceof BaseActivity) {
    		((BaseActivity)act).setActionbarTitle(title);
    	}
    }

    protected void setTitle (int resourceId) {
    	
    	Activity act = getActivity(); 
    	if ( act != null && act instanceof BaseActivity) {
    		((BaseActivity)act).setActionbarTitle(getString(resourceId));
    	}
    }
    protected void showSupportActionBar(boolean showActionBar){
    	Activity act = getActivity(); 
    	if ( act != null && act instanceof BaseActivity) {
    		((BaseActivity)act).setShowActionbar(showActionBar);
    	}
    }
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
}
