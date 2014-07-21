package com.abewy.android.extended.adapter;

import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.abewy.android.extended.R;
import com.abewy.android.extended.model.ItemType2;

public class ItemType2Adapter extends BaseAdapter
{
	private List<? extends Object> items;
	
	public ItemType2Adapter(List<? extends Object> items)
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
		if (convertView == null)
		{
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.item_type2, parent, false);
			convertView.setTag(new ViewHolder((TextView) convertView.findViewById(R.id.title), convertView.findViewById(R.id.color_view)));
		}
		
		ViewHolder holder = (ViewHolder) convertView.getTag();
		ItemType2 item = (ItemType2) getItem(position);
		
		holder.title.setText(item.title);
		holder.color.setBackgroundColor(item.color);
		
		return convertView;
	}
	
	private static class ViewHolder
	{
		public final TextView title;
		public final View color;
		
		public ViewHolder(TextView title, View color)
		{
			this.title = title;
			this.color = color;
		}
	}

}
