package com.learnme;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import com.ljp.ani.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.Toast;


public class StaringAct extends Activity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Called when the activity is first created. */
	private MyPageWidget mPageWidget;
	Context cx;
	Bitmap mCurPageBitmap, mNextPageBitmap;
	Canvas mCurPageCanvas, mNextPageCanvas;
	MyBookPageFactory pagefactory;
	private String bookPath;
	private DisplayMetrics dm;
	private ActivityManager am;
	public int bookName =0;
	public int fileNameSingle =0;
	private String filename = "resume"; //file name
	
	@SuppressLint({ "WrongCall", "SdCardPath", "ClickableViewAccessibility" }) @Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		mPageWidget = new MyPageWidget(this);
		setContentView(mPageWidget);
		am = ActivityManager.getInstance();
		am.addActivity(this);

		
		@SuppressWarnings("deprecation")
		FrameLayout.LayoutParams params = new 
		FrameLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, 
		FrameLayout.LayoutParams.WRAP_CONTENT); 
		params.gravity=Gravity.BOTTOM|Gravity.RIGHT;  
	
		dm=new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);    
		int width=dm.widthPixels;
		int height=dm.heightPixels;
		mCurPageBitmap = Bitmap.createBitmap(width, height-50, Bitmap.Config.ARGB_8888);//当前页面大小
		mNextPageBitmap = Bitmap
				.createBitmap(dm.widthPixels,dm.heightPixels-50, Bitmap.Config.ARGB_8888);//下一页
		mCurPageCanvas = new Canvas(mCurPageBitmap);
		mNextPageCanvas = new Canvas(mNextPageBitmap);
		
		pagefactory = new MyBookPageFactory(width,height);
		pagefactory.setBgBitmap(BitmapFactory.decodeResource(
				this.getResources(), R.drawable.bookback));
		try {
			
			copy(filename);
			bookPath="/data/data/com.ljp.ani/files/"+filename+".txt";
			pagefactory.openbook(bookPath);
			pagefactory.onDraw(mCurPageCanvas);
			
		} catch (IOException e1) {
			e1.printStackTrace();
			Toast.makeText(this, "电子书不存在",
					Toast.LENGTH_SHORT).show();
		}
		

		mPageWidget.setBitmaps(mCurPageBitmap, mCurPageBitmap);

		
		mPageWidget.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent e) {
				boolean ret=false;
				if (v == mPageWidget) {
					if (e.getAction() == MotionEvent.ACTION_DOWN) {
						mPageWidget.abortAnimation();
						mPageWidget.calcCornerXY(e.getX(), e.getY());

						pagefactory.onDraw(mCurPageCanvas);
						if (mPageWidget.DragToRight()) {
							try {
								pagefactory.prePage();
							} catch (IOException e1) {
								e1.printStackTrace();
							}						
							if(pagefactory.isfirstPage())
								return false;
							pagefactory.onDraw(mNextPageCanvas);
						} else {
							try {
								pagefactory.nextPage();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							if(pagefactory.islastPage())return false;
							pagefactory.onDraw(mNextPageCanvas);
						}
						mPageWidget.setBitmaps(mCurPageBitmap, mNextPageBitmap);
					}
                 
					 ret = mPageWidget.doTouchEvent(e);
					return ret;
				}
				return false;
			}

		});
	}

	@SuppressLint("SdCardPath") 
	private void copy(String filename) {
		
		
		try {
			
			String filePath="/data/data/com.ljp.ani/files/";
			File file=new File(filePath);
			if(!file.exists()){
				file.mkdir();
			}
			AssetManager assetManage=this.getAssets();
			
			if(!new File(filePath+filename+".txt").exists()){
				InputStream in=assetManage.open(filename+".jpg");
				BufferedInputStream bis = new BufferedInputStream(in);
				 BufferedOutputStream bos = new BufferedOutputStream(
				 new FileOutputStream(filePath+filename+".txt"));
				 byte[] buffer = new byte[8192];
				 int length = 0;
				 while ((length = (bis.read(buffer))) > 0) {
				 bos.write(buffer, 0, length);
				 }
				 bis.close();
				 bos.close();
				 
			}	
				 } catch (IOException e) {
				 e.printStackTrace();
				 }
			
	}
	

	@Override
	protected void onResume() {
		super.onResume();
		
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

}
