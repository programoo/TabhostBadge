package com.example.tabhostbadge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab1Fragment extends Fragment  {
	String tag = getClass().getSimpleName();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		Log.d(tag, "onCreateView");
	    // Inflate the layout for this fragment
	    View V = inflater.inflate(R.layout.tab1_view, container, false);
	
	    return V;
	}
}