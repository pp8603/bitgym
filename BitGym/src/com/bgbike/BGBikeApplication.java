package com.bgbike;

import android.app.Application;

public class BGBikeApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
//		Ubertesters.initialize(this, LockingMode.LockingModeDisableUbertestersIfBuildNotExist);
	}
}