package com.harataira.vinotory.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.harataira.vinotory.R;

public class MainActivity extends GeneralMenuActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void startAddBottleActivity(View view) {
	    Intent intent = new Intent(this, AddWineBottleActivity.class);
	    startActivity(intent);
	}
}
