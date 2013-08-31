package com.example.tabhostbadge;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements
		OnTabChangeListener {
	String tag = this.getClass().getSimpleName();
	private FragmentTabHost mTabHost;
	TabSpec tab_news;
	Paint p = new Paint();
	int new_count=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(tag, "onCreate");

		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setOnTabChangedListener(this);
		
		mTabHost.setup(this, getSupportFragmentManager(), R.id.tab1);
		tab_news = mTabHost.newTabSpec("tab1");
		tab_news.setIndicator( getBadgeView("1",10 ) ); 
		mTabHost.addTab(tab_news,Tab1Fragment.class,null);

		mTabHost.setup(this, getSupportFragmentManager(), R.id.tab2);
		mTabHost.addTab(
				mTabHost.newTabSpec("tab2").setIndicator(getBadgeView("20",20)),
				Tab2Fragment.class, null);

		mTabHost.setup(this, getSupportFragmentManager(), R.id.tab3);
		mTabHost.addTab(
				mTabHost.newTabSpec("tab3").setIndicator(getBadgeView("300",100)),
				Tab3Fragment.class, null);
		
		

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		Log.d(tag,"key press");

		TextView v = (TextView) mTabHost.getTabWidget().getChildAt(0).findViewById(R.id.badge_count);
		v.setText(""+new_count++);
		return super.onKeyDown(keyCode, event);		
	}
	public Bitmap getBadgeBitmap(int notification_count){
		InputStream is = this.getResources().openRawResource(
				R.drawable.ic_launcher);
		Bitmap bitmap1 = BitmapFactory.decodeStream(is);
		Bitmap bmOverlay = Bitmap.createBitmap(bitmap1.getWidth(),
				bitmap1.getHeight(), bitmap1.getConfig());
		
		Canvas canvas = new Canvas(bmOverlay);
		//canvas.setDensity(100);
		canvas.drawBitmap(bitmap1, 0, 0, null);
		Paint p = new Paint();
		p.setColor(Color.RED);
		canvas.drawCircle(10, 10, 10, p);
		p.setTextSize(10);
		p.setStrokeWidth(1);
		p.setStyle(Paint.Style.STROKE);
		p.setColor(Color.WHITE);
		canvas.drawText("" + notification_count, 0+2, p.getTextSize()+2, p);

		
		
		return bmOverlay;
	}
	public View getBadgeView(String textName,int notification_count) {
		
		LayoutInflater lf = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		View v = lf.inflate(R.layout.badge_view, null);

		ImageView badge_bg_imgView = (ImageView) v.findViewById(R.id.badge_bg);
		badge_bg_imgView.setImageResource(R.drawable.ic_launcher);
		
		TextView tv = (TextView) v.findViewById(R.id.badge_count);
		tv.setTextColor(Color.WHITE);
		tv.setText( textName );

		return v;

	}

	@Override
	public void onTabChanged(String tabId) {
		Log.d(tag, "onTabChanged(): tabId=" + tabId);
	}

}
