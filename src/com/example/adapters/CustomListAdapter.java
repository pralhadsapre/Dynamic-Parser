package com.example.adapters;

import java.util.ArrayList;

import com.example.models.NavigationDrawerItem;
import com.example.novice.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<NavigationDrawerItem> {

	private Context context;
	private ArrayList<NavigationDrawerItem> items;

	public CustomListAdapter(Context context,
			ArrayList<NavigationDrawerItem> objects) {
		super(context, R.layout.drawer_item, objects);
		// TODO Auto-generated constructor stub

		this.context = context;
		this.items = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(R.layout.drawer_item, parent, false);
		TextView title = (TextView) rowView.findViewById(R.id.listTitle);
		TextView caption = (TextView) rowView.findViewById(R.id.listCaption);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.listIcon);

		title.setText(items.get(position).getTitle());
		caption.setText(items.get(position).getCaption());
		imageView.setImageResource(items.get(position).getIcon());

		return rowView;
	}
}
