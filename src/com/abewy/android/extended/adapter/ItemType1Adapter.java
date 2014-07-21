package com.abewy.android.extended.adapter;

import java.util.List;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.abewy.android.extended.R;
import com.abewy.android.extended.model.ItemType1;

public class ItemType1Adapter extends BaseAdapter
{
	private List<? extends Object> items;
	
	public ItemType1Adapter(List<? extends Object> items)
	{
		this.items = items;
	}
	
	@Override
	public int getCount()
	{
		return items != null ? items.size() : 0;
	}

	@Override
	public Object getItem(int position)
	{
		return items.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		Log.d("ItemType1Adapter", "getView: " + position);
		if (convertView == null)
		{
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.item_type1, parent, false);
			convertView.setTag(new ViewHolder((TextView) convertView.findViewById(R.id.title), (TextView) convertView.findViewById(R.id.desc)));
		}
		
		ViewHolder holder = (ViewHolder) convertView.getTag();
		ItemType1 item = (ItemType1) getItem(position);
		
		holder.title.setText(item.title);
		holder.desc.setText(item.desc);
		
		return convertView;
	}
	
	private static class ViewHolder
	{
		public final TextView title;
		public final TextView desc;
		
		public ViewHolder(TextView title, TextView desc)
		{
			this.title = title;
			this.desc = desc;
		}
	}

}
