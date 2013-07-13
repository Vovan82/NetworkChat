package com.TronenkoVladimir.networkchat;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CheatActivity extends Activity{

	private MessageAdapter mAdapter;
	private EditText mSendEditText;

	private final static List<Message> mChat = new ArrayList<Message>();
	
	static {
		mChat.add(new Message("dj sender", "dj light", "lets play"));
		mChat.add(new Message("out", "nowhere", "test message"));
		mChat.add(new Message("Vladimir", "Yanukovich", "Hello mr. president"));

}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		
		findViewById(R.id.chat_send_button).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String sendText = mSendEditText.getText().toString();
				if(sendText==null || sendText.trim().length()==0){
					Toast.makeText(CheatActivity.this, "Enter text!", Toast.LENGTH_SHORT).show();
				}
				else{
					Message m = new Message("Yanukovich","You",sendText);
					mChat.add(m);
					mAdapter.notifyDataSetChanged();
					mSendEditText.setText(new String());

				}
			}
		});
	}


}