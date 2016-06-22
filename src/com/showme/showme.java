package com.showme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ljp.ani.R;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class showme extends ListActivity {
	
	 // private List<String> data = new ArrayList<String>();
	 
	//online video path
	private String video_path = "http://www.openengineer.cn/videos/";
	//video name 
	private String video_name[]={
		
		"pingpang.mp4",
		"carcontroller.mp4",
		"rfid.mp4",
		"timer.mp4",
		"led.mp4",			
		"car.mp4",
		"Billboard.mp4",
		"flash_led.mp4",
		"fangdao.mp4",
		"turbidity.mp4",
		
	};
	
	//listview item info
	
	private String video_info[]={
			
		"乒乓球游戏",  "使用Verilog语言，在Cyclone 4平台上开发的一款小游戏",
		"车载控制器",  "使用STM32单片机，搭配4.7寸TFT液晶屏设计的车辆控制系统",
		"RFID刷卡系统","使用TI公司的MSP430超低功耗单片机，结合RC522 RFID模块设计的刷卡系统",
		"电子时钟",	   "使用STC单片机结合LCD5110设计的一款电子钟，集成万年历，温度，闹钟，红外功能。",
		"多级调光台灯", "基于开关工作模式的多级调光台灯，软件实现红外编解码，外加环境光检测控制功能",
		"简易无线遥控车","主控采用ST公司的STM8单片机，2.4G无线控制，分立元件实现电调",
		"WIFI更新广告牌","LED电子广告牌，可以使用WIIF远程更新显示内容",
		"相机闪光电路","相机闪光控制电路，按下按键自动充满电，再次按下放电闪光",
		"防盗报警系统","基于FPGA+NIOS2设计的多路防盗报警系统，通过键盘输入密码来解除报警或停止报警",
		"水浊度检测器", "用来检测水质浑浊度，数值范围为0~100。",
		
		
	};
	
    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // load simpleadaper 
        SimpleAdapter adapter = new SimpleAdapter(
        		
        	this,getData(),
        		
        	R.layout.vlist,

            new String[]{"title","info","img"},

            new int[]{R.id.title,R.id.info,R.id.img}
        		
        );

        setListAdapter(adapter);
 

    }

 
    //load video information
    
    private List<Map<String, Object>> getData() {

    	int count;
    	
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map;
        
        //use for cycle to load the video information
        
        for(count =0;  count < video_info.length; ){
        	
        	map = new HashMap<String, Object>();
        	
        	map.put("title", video_info[count++]);  //add titile

            map.put("info",   video_info[count++]); //add information

            map.put("img", R.drawable.img_ico);//add picture

            list.add(map);
        	
        }
      
        return list;

    }
    
   //click handle function 
    protected void onListItemClick(ListView l, View v, int position, long id) {  
        
    	//Toast.makeText(showme.this, "You click: " + id, Toast.LENGTH_SHORT).show();  
        
    	super.onListItemClick(l, v, position, id); 
    	
    	Intent it = new Intent(); 
	    it.setAction(Intent.ACTION_VIEW);  
	    it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
	    Uri uri = Uri.parse(video_path + video_name[position]);//此url就是流媒体文件的下载地址 
	    it.setDataAndType(uri, "video/mp4"); //type的值是 "video/*"或者 "audio/*"  
	    startActivity(it);
    	
    }  

   
}


