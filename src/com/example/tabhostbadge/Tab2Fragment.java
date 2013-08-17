package com.example.tabhostbadge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab2Fragment extends Fragment  {
	String tag = getClass().getSimpleName();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		Log.d(tag, "onCreateView");
	    // Inflate the layout for this fragment
	    View V = inflater.inflate(R.layout.tab1_view, container, false);
	    
	    TextView tv = (TextView) V.findViewById(R.id.fragment_textview);
	    tv.setText("this is fragment from class "+tag);
	    return V;
	}
}