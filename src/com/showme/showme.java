package com.showme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ljp.ani.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class showme extends ListActivity {
	
	 // private List<String> data = new ArrayList<String>();

	private String url[]={
			
		"http://www.openengineer.cn/videos/girl.mp4",
		"http://www.openengineer.cn/videos/dream.mp4",
		"http://www.openengineer.cn/videos/ourtime.mp4",
		"http://www.openengineer.cn/videos/girl.mp4",
		"http://www.openengineer.cn/videos/girl.mp4",
		"http://www.openengineer.cn/videos/girl.mp4",
			
	};
	
	
	
    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

 

        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.vlist,

                new String[]{"title","info","img"},

                new int[]{R.id.title,R.id.info,R.id.img});

        setListAdapter(adapter);
 

    }

 

    private List<Map<String, Object>> getData() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

 

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("title", "乒乓球游戏");

        map.put("info", "使用Verilog语言，在Cyclone 4平台上开发的一款小游戏。");

        map.put("img", R.drawable.img_ico);

        list.add(map);

 

        map = new HashMap<String, Object>();

        map.put("title", "车载控制器");

        map.put("info", "使用STM32单片机，搭配4.7寸TFT液晶屏设计的车辆控制系统");

        map.put("img", R.drawable.img_ico);

        list.add(map);

 

        map = new HashMap<String, Object>();

        map.put("title", "RFID刷卡系统");

        map.put("info", "使用TI公司的MSP430超低功耗单片机，结合RC522 RFID模块设计的刷卡系统");

        map.put("img", R.drawable.img_ico);

        list.add(map);
        
        
        map = new HashMap<String, Object>();

        map.put("title", "RFID刷卡系统");

        map.put("info", "使用TI公司的MSP430超低功耗单片机，结合RC522 RFID模块设计的刷卡系统");

        map.put("img", R.drawable.img_ico);

        list.add(map);
        
        
        map = new HashMap<String, Object>();

        map.put("title", "RFID刷卡系统");

        map.put("info", "使用TI公司的MSP430超低功耗单片机，结合RC522 RFID模块设计的刷卡系统");

        map.put("img", R.drawable.img_ico);

        list.add(map);
        
        
        
        map = new HashMap<String, Object>();

        map.put("title", "RFID刷卡系统");

        map.put("info", "使用TI公司的MSP430超低功耗单片机，结合RC522 RFID模块设计的刷卡系统");

        map.put("img", R.drawable.img_ico);

        list.add(map);
        
        
        return list;

    }
    
    protected void onListItemClick(ListView l, View v, int position, long id) {  
        
    	//Toast.makeText(showme.this, "You click: " + id, Toast.LENGTH_SHORT).show();  
        
    	super.onListItemClick(l, v, position, id); 
    	
    	Intent it = new Intent(); 
	    it.setAction(Intent.ACTION_VIEW);  
	    it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
	    Uri uri = Uri.parse(url[position]);//此url就是流媒体文件的下载地址 
	    it.setDataAndType(uri, "video/mp4"); //type的值是 "video/*"或者 "audio/*"  
	    startActivity(it);
    	
    }  

   
}



/*


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
		        it.setDataAndType(uri, "video/mp4"); //type的值是 "video/*"或者 "audio/*"  
		        startActivity(it);
		    	 
		    } 
		    
		});
		
	}
	
}*/	
