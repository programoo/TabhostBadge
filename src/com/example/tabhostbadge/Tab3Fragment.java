package com.example.tabhostbadge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab3Fragment extends Fragment  {
	String tag = getClass().getSimpleName();
	
	public Tab3Fragment(){
		Log.d(tag, "Tab3Fragment");
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		Log.d(tag, "onCreateView");
	    // Inflate the layout for this fragment
	    View v = inflater.inflate(R.layout.tab3_view, container, false);
	    TextView tv = (TextView) v.findViewById(R.id.fragment_textview3);
	    tv.setText("this is fragment from class "+tag);
	    return v;
	}
}