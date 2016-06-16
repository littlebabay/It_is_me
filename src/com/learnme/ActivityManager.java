package com.learnme;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;


public class ActivityManager {
	private static ActivityManager instance;
	private List<Activity> list;

	public static ActivityManager getInstance() {
		if (instance == null)
			instance = new ActivityManager();
		return instance;
	}

	public void addActivity(Activity av) {
		if(list==null)
			list=new ArrayList<Activity>();
		if (av != null) {
			list.add(av);
		}
	}


	public void exitAllProgress() {
		for (int i = 0; i < list.size(); i++) {
			Activity av = list.get(i);
			av.finish();
		}
	}

}
