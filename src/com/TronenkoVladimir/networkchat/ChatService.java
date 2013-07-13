package com.TronenkoVladimir.networkchat;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class ChatService extends Service{
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	public static class SelfBinder extends Binder{
		public final ChatService srv;
		public SelfBinder(ChatService srv){
			this.srv=srv;
		}
	}
}