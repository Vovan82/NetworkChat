package com.TronenkoVladimir.networkchat;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CheatActivity extends Activity{

//	private MessageAdapter mAdapter;

	private final static List<Message> mChat = new ArrayList<Message>();
	
	static {
		mChat.add(new Message("dj sender", "dj light", "lets play"));
		mChat.add(new Message("out", "nowhere", "test message"));
		mChat.add(new Message("Vladimei", "Yanukovich", "Hello mr. president"));

}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);
		
		findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				EditText ed = (EditText)findViewById(R.id.message);
				
               if(ed==null){
            	   
               }
			}
		});
}
}