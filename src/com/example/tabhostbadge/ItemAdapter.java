package com.example.tabhostbadge;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ItemAdapter extends ArrayAdapter<String> {
	private Context context;
	private ArrayList<String> Ids;
	public ItemAdapter(Context context, ArrayList<String> objects) {
		super(context, R.layout.tab1_view, objects);
		this.context = context;
		this.Ids = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		System.out.println("position load: "+position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(position, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.fragment_textview1);

        textView.setText( "hello");

		return rowView;
	}

}