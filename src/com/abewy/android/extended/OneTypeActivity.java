package com.abewy.android.extended;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.abewy.android.extended.adapter.AggregatedAdapter;
import com.abewy.android.extended.adapter.ItemType1Adapter;
import com.abewy.android.extended.model.ItemType1;

public class OneTypeActivity extends Activity
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
		
		List<ItemType1> items = new ArrayList<ItemType1>();
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		adapters.add(new ItemType1Adapter(items));
		
		AggregatedAdapter aadapter = new AggregatedAdapter(adapters);
		
		list.setAdapter(aadapter);
	}
}
