package com.TronenkoVladimir.networkchat;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

abstract class BaseActivity extends Activity {

	private ServiceConnection mSrvConn;
	protected ChatService mCore;

	public void onCreate(Bundle b) {
		super.onCreate(b);
		Intent intent = new Intent();
		intent.setClass(this, ChatService.class);
		startService(intent);
		mSrvConn = new ServiceConnection() {

			@Override
			public void onServiceDisconnected(ComponentName arg0) {
				//
				finish();
			}

			@Override
			public void onServiceConnected(ComponentName arg0, IBinder service) {

				mCore = ((ChatService.SelfBinder) service).srv;
			}
		};
		bindService(intent, mSrvConn, BIND_AUTO_CREATE);
	}
	@Override
	public void onDestroy(){
		unbindService(mSrvConn);
		super.onDestroy();
	}
	abstract protected void onConnectedToService();

}
