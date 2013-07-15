package com.TronenkoVladimir.networkchat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistryActive extends Activity {
	private EditText age;
	private EditText male;
	private EditText female;

	private EditText pasworldA;
	private EditText pasworldB;

	@Override
	protected void onCreate(Bundle savedinstanceState) {
		super.onCreate(savedinstanceState);
		setContentView(R.layout.activity_register);

		age = (EditText) findViewById(R.id.Age);
		male = (EditText) findViewById(R.id.Male);
		female = (EditText) findViewById(R.id.Female);

		pasworldA = (EditText) findViewById(R.id.PaswordA);
		pasworldB = (EditText) findViewById(R.id.PaswordB);

	}

	public void onRegistryClick(View view) {
		String ag = age.getTag().toString();
		
		//if (ag == 0) {

		}
	

	}


