package com.example.mc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.*;

public class Set_num extends Activity
{
	static String number = null;
	EditText num;

	@Override
	protected void onCreate(Bundle onSavedInstanceState)
	{
		super.onCreate(onSavedInstanceState);
		setContentView(R.layout.set_num);
		num = (EditText) findViewById(R.id.num);
	}

	public void onClick_Confirm(View view)
	{
		number = num.getText().toString();
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		startActivity(intent);
	}
	public void onClick_Cancel(View view)
	{
		finish();
	}
}