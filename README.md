AggregatedAdapter
=================

An adapter that handles one or more data types in your listview/gridview.
The purpose of this library is to the listview adapter nightmare when you have to handle more that one kind of item view.
I'm sure you're trying to handle this in the Adapter.getView method, switching on getItemViewType(), ending with an ugly long code. Now you can define one adapter for each data view. Much simpler. Simply add it to the AggregateAdapter and it will do the magic for you.

How to can I get it into my project ?
=================

Simply import the class com.abewy.android.extended.adapter.AggregatedAdapter in your project


How does it work ?
=================

```java
ListView list = (ListView) findViewById(R.id.list);

List<BaseAdapter> adapters = new ArrayList<BaseAdapter>(); //<- your "normal" adapters
//Add some adapters, they must extend BaseAdapter

list.setAdapter(aadapter);
//done, easy !
```

Ok you might not have really understood how this works so far. Here is a more detailed example :

```java
public class TwoTypesActivity extends Activity
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
		
		//HeaderAdapter take only one header. I don't think you want a list
		//with severals consecutives headers, do you ? 
		adapters.add(new HeaderAdapter(new Header("Header1")));
		
		//Now you add your items for header 1
		List<ItemType1> items = new ArrayList<ItemType1>();
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		items.add(new ItemType1("Lorem ipsum dolor sit amet", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam."));
		//Add a new adapter that will handle ItemType1 items
		adapters.add(new ItemType1Adapter(items));
		
		//Adding a second header
		adapters.add(new HeaderAdapter(new Header("Header2")));
		
		//Complete with the set of items for section 2
		items = new ArrayList<ItemType1>();
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
```

The result is this :

![screen 1](/screenshot1.png)

In this example, we have mixed some Header and ItemType1 data items. But we can have only Header items, or ItemType1, or a mix of Header, ItemType1, ItemType2 items, or whatever other mix of custom data items.

You can then reuse your adapters in other lists, and mix them as well as needed.

You can check and run the example code for further details.


Wow, no gradle here, WTF ?
=================

Sorry man, I'm working with Eclipse (wait what ?). As long as Android Studio is not in release version, I won't do Gradle.
Now, I think it's a little project and you can convert it yourself, just fork it.


Compatibility
=================

Although the minSDK in the manifest is API 14, API 8 should work as well. I didn't want to have to handle this damn ActionBarCompat library. By the way, you should really stop making apps for API < 15.

