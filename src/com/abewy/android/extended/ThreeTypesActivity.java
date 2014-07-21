package com.abewy.android.extended;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.abewy.android.extended.adapter.AggregatedAdapter;
import com.abewy.android.extended.adapter.HeaderAdapter;
import com.abewy.android.extended.adapter.ItemType1Adapter;
import com.abewy.android.extended.adapter.ItemType2Adapter;
import com.abewy.android.extended.model.Header;
import com.abewy.android.extended.model.ItemType1;
import com.abewy.android.extended.model.ItemType2;

public class ThreeTypesActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView list = (ListView) findViewById(R.id.list);
		list.setDividerHeight(0);
		list.setClipToPadding(false);
		list.setScrollBarStyle(ListView.SCROLLBARS_OUTSIDE_INSET);
		
		List<BaseAdapter> adapters = new ArrayList<BaseAdapter>();
		
		adapters.add(new HeaderAdapter(new Header("Type 1")));
		
		List<Object> items = new ArrayList<Object>();
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		adapters.add(new ItemType1Adapter(items));
		
		adapters.add(new HeaderAdapter(new Header("Type 2")));
		
		items = new ArrayList<Object>();
		items.add(new ItemType2("Lorem ipsum dolor sit amet", 0xFF33B5E5));
		items.add(new ItemType2("Lorem ipsum dolor sit amet", 0xFF0099CC));
		items.add(new ItemType2("Lorem ipsum dolor sit amet", 0xFF99CC00));
		adapters.add(new ItemType2Adapter(items));
		
		adapters.add(new HeaderAdapter(new Header("Types 1 et 2")));
		
		items = new ArrayList<Object>();
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		adapters.add(new ItemType1Adapter(items));
		
		items = new ArrayList<Object>();
		items.add(new ItemType2("Lorem ipsum dolor sit amet", 0xFFFF4444));
		adapters.add(new ItemType2Adapter(items));
		
		items = new ArrayList<Object>();
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		adapters.add(new ItemType1Adapter(items));
		
		items = new ArrayList<Object>();
		items.add(new ItemType2("Lorem ipsum dolor sit amet", 0xFFAA66CC));
		adapters.add(new ItemType2Adapter(items));
		
		AggregatedAdapter aadapter = new AggregatedAdapter(adapters);
		
		list.setAdapter(aadapter);
	}
}
