package com.TronenkoVladimir.networkchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

import com.TronenkoVladimir.networkchat.Parser.ParserException;

public class RoomsActivity extends BaseActivity {
	private RoomsAdapter mAdapter;
	private ListView listview;

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_rooms);

	    listview=(ListView)findViewById(R.id.list);



	    listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View v, int position,
					long itemId) {

				//Toast.makeText(rooms_activity.this, items[position], Toast.LENGTH_SHORT).show();
				startActivity(new Intent(RoomsActivity.this,CheatActivity.class));
			}
		});
	    listview.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View v,
					int position, long itemId) {
			//	Toast.makeText(rooms_activity.this, items[position]+"LONGPRESSS", Toast.LENGTH_SHORT).show();
				return true;
			}
		});
	}
	@Override
	protected void onConnectedToService() {
		 try {
				mAdapter = new RoomsAdapter(this,mCore.getApi().getRooms());
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    listview.setAdapter(mAdapter);
	}
	@Override
	public void onBackPressed(){
//		android.os.Process.killProcess(android.os.Process.myPid());
		stopSystem();
		super.onBackPressed();
	}

}