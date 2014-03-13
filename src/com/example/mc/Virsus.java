package com.example.mc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Virsus extends Activity
{
	boolean flag = true;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.virsus);

	}

	public void onClick_Launch(View view)
	{
		Intent launch = new Intent(Intent.ACTION_MAIN);
		launch.addCategory(Intent.CATEGORY_HOME);
		startActivity(launch);
	}

	@Override
	public void onRestart()
	{
		super.onRestart();
		if (flag)
		{
			Intent splash = new Intent(this, Splash.class);
			startActivity(splash);
			flag = false;
		}
		finish();
	}
}
