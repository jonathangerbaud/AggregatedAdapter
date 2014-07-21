package com.abewy.android.extended;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView list = (ListView) findViewById(R.id.list);
		
		List<String> activities = new ArrayList<String>();
		activities.add("One type list");
		activities.add("Two types list");
		activities.add("Three types list");
		
		list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, activities));
		
		list.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		if (position == 0)
		{
			Intent intent = new Intent(this, OneTypeActivity.class);
			startActivity(intent);
		}
		else if (position == 1)
		{
			Intent intent = new Intent(this, TwoTypesActivity.class);
			startActivity(intent);
		}
		else if (position == 2)
		{
			Intent intent = new Intent(this, ThreeTypesActivity.class);
			startActivity(intent);
		}
	}
}
