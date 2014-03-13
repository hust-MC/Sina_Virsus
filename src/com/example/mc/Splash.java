package com.example.mc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.*;
import android.view.*;

;
public class Splash extends Activity
{
	private final int SPLASH_DISPLAY_LENGHT = 2000; // —”≥Ÿ¡Ω√Î

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Log.d("MC", "splash");
		new Handler().postDelayed(new Runnable()
		{

			@Override
			public void run()
			{
				Intent mainIntent = new Intent(Splash.this, MainActivity.class);
				Splash.this.startActivity(mainIntent);
				Splash.this.finish();
			}

		}, SPLASH_DISPLAY_LENGHT);
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.d("MC", "splash_destroy");
	}
}
