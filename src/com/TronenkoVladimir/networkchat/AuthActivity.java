package com.TronenkoVladimir.networkchat;





import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.TronenkoVladimir.networkchat.Api.ApiException;


public class AuthActivity extends BaseActivity {
	
//	ServiceConnection mSrvCon = new ServiceConnection(){
//		
//	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auth);
		findViewById(R.id.login).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				buttonlog();
			}
		});
		findViewById(R.id.Registration).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				buttonReg(v);
			}
		});
//		AuthActivity.connect("http://www.ex.ua/search?s=hello_world");
//		String json = connect("http://10.2.1.43:6606/auth?email=test@test.ua&pass=1234");
//		try{
//		Parser  p =new Parser();
//		AuthInfo auth=p.Auth(json);
//		Toast.makeText(this, "Token: "+auth.mNick+"Nick: "+auth.mToken, Toast.LENGTH_LONG).show();
//		}
//		catch(Exception e){
//			Toast.makeText(this, "Error: "+e.getMessage(), Toast.LENGTH_LONG).show();
//		}
		
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}
	public void buttonReg(View v)
	{
		switch (v.getId()) 
		{
		    case R.id.Registration:
		        Intent intent = new Intent(this, RegistryActive.class);
		        startActivity(intent);
		        break;
	    }
	}
	public void buttonlog(){
		EditText email = (EditText) findViewById(R.id.EmailField);
		EditText pass = (EditText) findViewById(R.id.PaswordA);
		try{
			mCore.getApi().auth(email.getText().toString(), pass.getText().toString());
			Toast.makeText(AuthActivity.this, "Welcome!!!", Toast.LENGTH_LONG).show();
			Intent i = new Intent(this,RoomsActivity.class);
			startActivity(i);
			finish();
		}
		catch(ApiException e){
			Toast.makeText(AuthActivity.this, "O uuu", Toast.LENGTH_LONG).show();
		}
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		
		switch (item.getItemId()){
		case R.id.action_info:              //**************
			 
				
				toastAbout().show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public Toast toastAbout(){
		Toast toast = Toast.makeText(AuthActivity.this, 
				  "Created by Vovan\n" +
				  "Date of creation:\n" +
				  "13/07/2013\n" +
				  "Novomoskovsk city\n" 
				  , Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView fox = new ImageView(getApplicationContext());
		fox.setImageResource(R.drawable.andshield);
		toastView.addView(fox, 0);
		return toast;
	}

	@Override
	protected void onConnectedToService() {
		// TODO Auto-generated method stub
		
	}
	
}
