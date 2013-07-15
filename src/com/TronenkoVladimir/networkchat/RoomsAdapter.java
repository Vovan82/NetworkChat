package com.TronenkoVladimir.networkchat;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RoomsAdapter extends BaseAdapter{
	
	private final Context context;
	private final List<Room> list;
	
	
	public RoomsAdapter(Context context,List<Room>list){
		this.context=context;
		this.list=list;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View maskedView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Room item=list.get(position);
		if(maskedView==null){
			maskedView=LayoutInflater.from(context).inflate(R.layout.rooms_row,null);
		}
		TextView nameView=(TextView)maskedView.findViewById(R.id.name);
		nameView.setText(item.name);
		
		if(position % 2==1){
			maskedView.setBackgroundColor(0xff999999);  // row_position
		}else{
			maskedView.setBackgroundColor(0xff555555);
		} //((textView)maskedView.findViewByid(R.id.row_position)).setText(String.valueof(position+1);
		
		return maskedView;
	}

}
