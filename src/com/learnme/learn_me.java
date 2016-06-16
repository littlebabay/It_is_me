package com.learnme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ljp.ani.R;

import net.youmi.android.AdView;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/*
public class learn_me extends Activity {
	
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
	}
	
} 
*/

public class learn_me extends ListActivity implements Serializable {


	private static final long serialVersionUID = 1L;

		protected void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
		
			String[]options=new String[]{"bookico","bookname"};
			int[]ico=new int[]{R.id.imageico,R.id.textappname};
			List<Map<String,Object>> items=new ArrayList<Map<String,Object>>();
			for(int i=0;i<ListViewItems.READ_NAME.length;i++){
				Map<String,Object>item=new HashMap<String,Object>();
				item.put("bookico", ListViewItems.READ_ICO[i]);
				item.put("bookname", ListViewItems.READ_NAME[i]);
				items.add(item);
			}
			SimpleAdapter adapter=new SimpleAdapter(this,items,R.layout.listview,options,ico);
			setListAdapter(adapter);
			AdView adView = new AdView(this); 
	         
			FrameLayout.LayoutParams params = new 
			FrameLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, 
			FrameLayout.LayoutParams.WRAP_CONTENT); 
			params.gravity=Gravity.BOTTOM|Gravity.RIGHT;  
			//Activity  
			addContentView(adView, params);  
			
	
	} 	
		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
			super.onListItemClick(l, v, position, id);
			Intent intent = new Intent();
			intent.putExtra("id", position);
			intent.setClass(learn_me.this, StaringAct.class);
			startActivity(intent);
		}
		
}
