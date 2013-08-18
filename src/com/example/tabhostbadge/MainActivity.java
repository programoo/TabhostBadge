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
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements
		OnTabChangeListener {
	String tag = this.getClass().getSimpleName();
	private FragmentTabHost mTabHost;
	Tab2Fragment f2 = new Tab2Fragment();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(tag, "onCreate");

		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setOnTabChangedListener(this);
		
		mTabHost.setup(this, getSupportFragmentManager(), R.id.tab1);
		mTabHost.addTab(
				mTabHost.newTabSpec("tab1").setIndicator(getBadgeView("ข่าว",10)),
				Tab1Fragment.class, null);

		mTabHost.setup(this, getSupportFragmentManager(), R.id.tab2);
		mTabHost.addTab(
				mTabHost.newTabSpec("tab2").setIndicator(getBadgeView("กล้อง",20)),
				Tab2Fragment.class, null);

		mTabHost.setup(this, getSupportFragmentManager(), R.id.tab3);
		mTabHost.addTab(
				mTabHost.newTabSpec("tab3").setIndicator(getBadgeView("วิทยุ",100)),
				Tab3Fragment.class, null);

	}

	public View getBadgeView(String textName,int notification_count) {

		Paint p = new Paint();
		LayoutInflater lf = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

		View v = lf.inflate(R.layout.badge_view, null);

		InputStream is = this.getResources().openRawResource(
				R.drawable.ic_launcher);
		Bitmap bitmap1 = BitmapFactory.decodeStream(is);
		Bitmap bmOverlay = Bitmap.createBitmap(bitmap1.getWidth(),
				bitmap1.getHeight(), bitmap1.getConfig());

		Canvas canvas = new Canvas(bmOverlay);
		// canvas.setDensity(160);
		canvas.drawBitmap(bitmap1, 0, 0, null);

		p.setColor(Color.RED);
		canvas.drawCircle(10, 10, 10, p);

		p.setStrokeWidth(2);
		p.setStyle(Paint.Style.STROKE);
		p.setColor(Color.WHITE);
		canvas.drawText("" + notification_count, 0, p.getTextSize(), p);

		ImageView iv = (ImageView) v.findViewById(R.id.imageView1);
		iv.setImageBitmap(bmOverlay);

		TextView tv = (TextView) v.findViewById(R.id.textView1);
		tv.setText( textName );

		return v;

	}

	@Override
	public void onTabChanged(String tabId) {
		Log.d(tag, "onTabChanged(): tabId=" + tabId);
		//FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
		//ft.replace(R.id.tab2, new Tab2Fragment(), tabId);
       //ft.replace(R.id.tab2,new Tab2Fragment() );
        //ft.commit();
	}

}
