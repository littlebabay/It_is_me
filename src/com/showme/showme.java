package com.showme;

import com.ljp.ani.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class showme extends Activity {

	private String url="";
	
	
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.showme);


		Button btn_play = (Button)findViewById(R.id.btn_play); 
		
		
		btn_play.setOnClickListener(new View.OnClickListener() {  
		      
		 
			public void onClick(View v) {  
		       
		    	//url = "/storage/emulated/0/girl.mp4";
        		url="http://www.openengineer.cn/videos/girl.mp4";
		        Intent it = new Intent(); 
		        it.setAction(Intent.ACTION_VIEW);  
		        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
		        Uri uri = Uri.parse(url);//此url就是流媒体文件的下载地址 
		        it.setDataAndType(uri, "video/*"); //type的值是 "video/*"或者 "audio/*"  
		        startActivity(it);
		    	
		    } 
		    
		});
		
	}
	
}
		
