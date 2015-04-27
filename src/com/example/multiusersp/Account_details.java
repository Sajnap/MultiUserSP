package com.example.multiusersp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.widget.Toast;

public class Account_details extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account);
		SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		String f1= sp.getString("first","null");
		String p1= sp.getString("pass","null");


		//String p2 = sp.getString("pass2","null");
		String cr= sp.getString("card","null");
		String na= sp.getString("name","null");

		String eml= sp.getString("email","null");
		String phno= sp.getString("phone","null");

		((TextView)findViewById(R.id.textView1)).setText("first name :"+f1+"\npassword: "+p1+"\nCredit card: "+cr+"\nname: "+na+"\nphone: "+phno+"\nemail:"+eml);

		Toast.makeText(getApplicationContext(),"first name"+f1+"\npassword"+p1+"\ncreditcard"+cr+"\n name"+na+"\nphone"+phno+"\nemail"+eml,Toast.LENGTH_LONG).show();


	}
}
