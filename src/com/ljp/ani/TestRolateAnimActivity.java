package com.ljp.ani;


import com.contactme.contactme;
import com.learnme.StaringAct;
import com.reserve.reserve;
import com.showme.showme;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class TestRolateAnimActivity extends Activity {
	
	MyImageView UI_learn_me,UI_show_me,UI_contact_me,UI_Reserve;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// four UI components
		UI_learn_me = (MyImageView) findViewById(R.id.learn_me);
		UI_show_me = (MyImageView) findViewById(R.id.show_me);
		UI_contact_me = (MyImageView) findViewById(R.id.contact_me);
		UI_Reserve = (MyImageView) findViewById(R.id.Reserve);
		
	
		
		//on click hander for the learn_me UI
		UI_learn_me.setOnClickIntent(new MyImageView.OnViewClick() {

			@SuppressLint("ShowToast")
			@Override
			public void onClick() {
				/*
				Toast.makeText(TestRolateAnimActivity.this, "learn_me", 100)
						.show();
					*/
				Intent intent = new Intent();
        		intent.setClass(TestRolateAnimActivity.this,StaringAct.class);
        		startActivity(intent);
        		//TestRolateAnimActivity.this.finish();
        		
			}
		});
		
		//on click hander for the show_me UI
		UI_show_me.setOnClickIntent(new MyImageView.OnViewClick() {

			@SuppressLint("ShowToast")
			@Override
			public void onClick() {
				/*
				Toast.makeText(TestRolateAnimActivity.this, "show_me", 100)
						.show();
				*/
				Intent intent = new Intent();
        		intent.setClass(TestRolateAnimActivity.this,showme.class);
        		startActivity(intent);
			}
		});
		
		//on click handler for the contact_me UI
		UI_contact_me.setOnClickIntent(new MyImageView.OnViewClick() {

			@SuppressLint("ShowToast")
			@Override
			public void onClick() {
				/*
				Toast.makeText(TestRolateAnimActivity.this, "contact_me", 100)
						.show();
						*/
				Intent intent = new Intent();
        		intent.setClass(TestRolateAnimActivity.this,contactme.class);
        		startActivity(intent);
			}
		});
		
		//on click hander for the weather UI
		UI_Reserve.setOnClickIntent(new MyImageView.OnViewClick() {

					@SuppressLint("ShowToast")
					@Override
			public void onClick() {
						
						/*
						Toast.makeText(TestRolateAnimActivity.this, "weather", 100)
								.show();
						*/
				Intent intent = new Intent();
		        intent.setClass(TestRolateAnimActivity.this,reserve.class);
		        startActivity(intent);		
						
			}
		});
		
		
	}
}