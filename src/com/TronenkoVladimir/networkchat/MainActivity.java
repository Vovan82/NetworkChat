package com.TronenkoVladimir.networkchat;

import com.TronenkoVladimir.networkchat.Api.ApiException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Api mApi;
	private EditText email;
	private EditText pasworld;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		View ButtonLogin=findViewById(R.id.fieldReg);
		
		
		email=(EditText)findViewById(R.id.EmailField);
		pasworld=(EditText)findViewById(R.id.NicField);
	
		
		
		
		
		
		mApi = new Api();
		ButtonLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String emai = email.getText().toString();
				
				if (emai.length() == 0) {
					Toast.makeText(MainActivity.this, "Error input email", Toast.LENGTH_SHORT).show();
				} else {
					String pas = pasworld.getText().toString();
					if (pas.length() == 0) {
						Toast.makeText(MainActivity.this, "Error input passworld", Toast.LENGTH_SHORT).show();
					} else {
						try {
							mApi.auth(emai, pas);
							Toast.makeText(MainActivity.this, "You can be registered", Toast.LENGTH_SHORT).show();
						} catch (ApiException e) {
							Toast.makeText(MainActivity.this, "Error email or passworld", Toast.LENGTH_SHORT).show();
						}
						
					}
				}
			}	
		});
		

		// connect("http://10.2.1.43:6606/auth?email=test@test.ua&pass=1234");
		// try {
		// AuthInfo info = new Parser().auth(s);
		// Toast.makeText(this,
		// "Token is: "+info.token,Toast.LENGTH_SHORT).show();
		// } catch (Exception e) {
		// Toast.makeText(this, "Error:_"+e.getMessage(),
		// Toast.LENGTH_SHORT).show();
		// }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) { // 1 создает меню
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// @Override
	public void onRegistryClick(View view) {
		Intent reg = new Intent();
		reg.setClass(this, RegistryActive.class);
		startActivity(reg);

	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) { // 2
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {//3 выбранная область меню

		switch (item.getItemId()) {
		case R.id.action_remind:
			startActivity(new Intent(this, RemindActivity.class));
			return true;
		}
		
		return true;

	}

}
