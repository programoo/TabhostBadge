package com.example.tabhostbadge;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	String tag=this.getClass().getSimpleName();
    private FragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(tag,"onCreate");
		
		mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator(getBadgeView()),
	            Tab1Fragment.class, null);
		
		mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator(getBadgeView()),
	            Tab1Fragment.class, null);
		
		mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator(getBadgeView()),
	            Tab1Fragment.class, null);
		
	}
	
	public View getBadgeView()
	{
		

		LayoutInflater lf = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		
		View v = lf.inflate(R.layout.view_template,null);
		
		
		InputStream is = this.getResources().openRawResource(R.drawable.ic_launcher);
		Bitmap bitmap1 = BitmapFactory.decodeStream(is);
        Bitmap bmOverlay = Bitmap.createBitmap(bitmap1.getWidth(), bitmap1.getHeight(), bitmap1.getConfig());
        
        Canvas canvas = new Canvas(bmOverlay);

        canvas.drawBitmap(bitmap1, 0, 0,null);
        canvas.drawRect(30, 30, 80, 80, new Paint());

        ImageView iv = (ImageView) v.findViewById(R.id.imageView1);
		iv.setImageBitmap(bmOverlay);
		
		TextView tv = (TextView) v.findViewById(R.id.textView1);
		tv.setText("");

        return v;

	}


}
