package com.TronenkoVladimir.networkchat;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MessageAdapter extends BaseAdapter {

	private final Context context;
	private final List<Message> list;

	public MessageAdapter(Context context, List<Message> list) {
		this.context = context;
		this.list = list;

	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View maskedView, ViewGroup parent) {
		Message item = list.get(position);
		if (maskedView == null) {
			maskedView = LayoutInflater.from(context).inflate(
					R.layout.message_row, null);
			
			
		}
		 TextView nickView=(TextView)maskedView.findViewById(R.id.message_row_nikc);
		 nickView.setText(item.getReciever());
		 
		 TextView timeView=(TextView)maskedView.findViewById(R.id.message_row_time);
		 timeView.setText("time:"+item.time);
		 
		 TextView mesaggeView=(TextView)maskedView.findViewById(R.id.message_row_mesagge);
		 mesaggeView.setText(item.getText());
		 
		return maskedView;

	}
}
