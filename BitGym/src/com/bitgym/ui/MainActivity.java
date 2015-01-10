
package com.bitgym.ui;

import android.os.Bundle;

import com.bitgym.R;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);	
		initializeDrawer("");
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
		this.finish();
	}
	@Override
	protected void onDestroy(){
		super.onDestroy();
	}
}
