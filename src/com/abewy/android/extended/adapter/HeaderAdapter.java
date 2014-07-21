package com.abewy.android.extended.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.abewy.android.extended.R;
import com.abewy.android.extended.model.Header;

public class HeaderAdapter extends BaseAdapter
{
	private final Header header;
	
	public HeaderAdapter(Header header)
	{
		this.header = header;
	}
	
	@Override
	public int getCount()
	{
		return 1;
	}

	@Override
	public Object getItem(int position)
	{
		return position;
	}

	@Override
	public long getItemId(int position)
	{
		return 0;
	}

	@Override
	public boolean isEnabled(int position)
	{
		return false;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if (convertView == null)
		{
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.item_header, parent, false);
			convertView.setTag(new ViewHolder((TextView) convertView.findViewById(R.id.textview)));
		}
		
		ViewHolder holder = (ViewHolder) convertView.getTag();
		holder.textView.setText(header.label);
		
		return convertView;
	}
	
	private static class ViewHolder
	{
		public final TextView textView;
		
		public ViewHolder(TextView textView)
		{
			this.textView = textView;
		}
	}

}
