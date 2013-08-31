package com.example.tabhostbadge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
  
    public CustomAdapter(Context context, String[] values) {
        super(context, R.layout.tab1_view, values);
         
        this.context = context;
        this.values = values;
    }
     
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         
        View view = inflater.inflate(R.layout.tab1_view, parent, false);
        TextView teamName = (TextView) view.findViewById(R.id.tab1_text);
        teamName.setText(values[position]);
        
        ImageView tab1_img = (ImageView) view.findViewById(R.id.tab1_img);
        tab1_img.setImageResource(R.drawable.ic_launcher);
         
        return view;
    }
 
}