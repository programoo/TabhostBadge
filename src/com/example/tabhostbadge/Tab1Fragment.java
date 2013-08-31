package com.example.tabhostbadge;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class Tab1Fragment extends ListFragment {
	private String tag = getClass().getSimpleName();

	public Tab1Fragment() {
		Log.d(tag, "Tab1Fragment");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
		        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		        "Linux", "OS/2" };
	    CustomAdapter adapter = new CustomAdapter(getActivity(),values);
	    setListAdapter(adapter);;
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
	    // Do something with the data
		Log.d(tag,"Click ListItem Number " + position );
	}

}