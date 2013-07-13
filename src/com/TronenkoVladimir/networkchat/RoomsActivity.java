package com.TronenkoVladimir.networkchat;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;

public class RoomsActivity extends Activity {
	
	private RoomsAdapter mAdapter;

	private final static List<Room> sRooms = new ArrayList<Room>();

	static {
		sRooms.add(new Room("Общий чат").setmPepoleCount(9).setmStatus(
				Room.Status.ok));
		sRooms.add(new Room("Не чат").setmPepoleCount(5).setmStatus(
				Room.Status.banned));
		sRooms.add(new Room("Кухня").setmPepoleCount(4).setmStatus(
				Room.Status.inside));
		
	
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_rooms);

		ListView listView = (ListView) findViewById(R.id.list);

		final String tests[] = { "One", "Two", "Three" };
		mAdapter = new RoomsAdapter(this, sRooms);

		listView.setAdapter(mAdapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapters, View v,
					int position, long itemid) {
				// TODO Auto-generated method stub
				Toast.makeText(RoomsActivity.this, tests[position],
						Toast.LENGTH_LONG).show();

			}
		});

		listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapters, View v,
					int position, long itemid) {
				// TODO Auto-generated method stub
				Toast.makeText(RoomsActivity.this,
						"LongClick" + tests[position], 1).show();
				return true;
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.rooms_menu, menu);
		return super.onCreateOptionsMenu(menu);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_rooms_add:
			// showAddroomDialog();
			showDialog(1);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private Dialog newAddroomDialog() {
		AlertDialog.Builder bilder;
		bilder = new AlertDialog.Builder(this);
		bilder.setTitle("Adding new room");

		final View view = LayoutInflater.from(this).inflate(R.layout.dialog,
				null);
		bilder.setView(view);

		bilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				String name = ((EditText) view
						.findViewById(R.id.dialog_room_add_name)).getText()
						.toString();
				if (name == null || name.trim().length() == 0) {
					Toast.makeText(RoomsActivity.this, "Misentry of the name",
							Toast.LENGTH_SHORT).show();

				} else {
					String desk = ((EditText) view
							.findViewById(R.id.dialog_room_add_desk)).getText()
							.toString();
					if (desk == null || desk.trim().length() == 0) {
						Toast.makeText(RoomsActivity.this,
								"Misentry of description", Toast.LENGTH_SHORT)
								.show();
					} else {
						Room r=new Room(name);
						r.setmPepoleCount(1);
						r.setmStatus(Room.Status.ok);
						sRooms.add(r);
						mAdapter.notifyDataSetChanged();
						
						
					}
				}
			}
		});

		bilder.setNegativeButton("Cancel", null);

		return bilder.create();
	}

	public Dialog onCreateDialog(int id) {
		if (1 == id) {

			return newAddroomDialog();
		}
		return super.onCreateDialog(id);
	}
	@Override
	public void onBackPressed(){
		android.os.Process.killProcess(android.os.Process.myPid());
	}
}