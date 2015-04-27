package com.example.multiusersp;

import java.util.StringTokenizer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends ActionBarActivity {

	ImageView profileImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

	}

	public void register(View v)

	{
		boolean registrationOk=true;
		//User details entered by user in Regration page

		EditText e=((EditText)findViewById(R.id.username_edit));
		String username_entered=e.getText().toString();

		EditText pass=((EditText)findViewById(R.id.password_edit));
		EditText credit=((EditText)findViewById(R.id.reenterpassword_edit));
		EditText name=((EditText)findViewById(R.id.name_edit));

		String password_entered=pass.getText().toString();
		String credit_entered=credit.getText().toString();
		String name_entered=name.getText().toString();
		EditText email=((EditText)findViewById(R.id.email_edit));

		String email_entered=email.getText().toString();
		EditText phn=((EditText)findViewById(R.id.phone_edit));

		String phone_entered=phn.getText().toString();

		if(email_entered.contains("@") && email_entered.contains(".")){
			if(! email_entered.matches("[A-Z a-z _]+@*.*")){
				Toast.makeText(getApplicationContext(), "Invalid Email id", Toast.LENGTH_LONG).show();
				registrationOk = false;
				return;
			}
		}else{
			Toast.makeText(getApplicationContext(), "No proper Email id", Toast.LENGTH_LONG).show();
			registrationOk = false;
			return;
		}


		if(username_entered.equals("")){
			Toast.makeText(getApplicationContext(), "Enter username", Toast.LENGTH_LONG).show();
			e.setError("Required");
			registrationOk = false;
			return;
		}else{
			String alluser=(PreferenceManager.getDefaultSharedPreferences(getApplicationContext())).getString("previous_registrations", "");
			if(alluser.contains(username_entered)){
				StringTokenizer stk=new StringTokenizer(alluser, "|");
				StringTokenizer stk2=null;
				int no_of_users = stk.countTokens();
				String usename="";
				for (int i = 0; i < no_of_users; i++) {
					stk2=new StringTokenizer(stk.nextToken(), ",");
					usename=(stk2.nextToken());
					if(usename.equalsIgnoreCase(username_entered)){
						Toast.makeText(getApplicationContext(), "Username Already exists! \n Please enter new username.", Toast.LENGTH_LONG).show();
						registrationOk = false;
						return;
					}
				}
			}
		}
		if(password_entered.equals("")){
			Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_LONG).show();
			pass.setError("Required");
			registrationOk = false;
			return;
		}

		if(name_entered.equals("")){
			Toast.makeText(getApplicationContext(), "Enter the Name", Toast.LENGTH_LONG).show();
			name.setError("Required");

			registrationOk = false;
			return;
		}

		int len=phone_entered.length(); 
		if(phone_entered.equals("")||len<10||len>=11) 
		{
			Toast.makeText(getApplicationContext(), "Enter the correct Phone number", Toast.LENGTH_LONG).show();
			registrationOk = false;
			return;
		}


		if(registrationOk){
			SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			Editor ed=PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
			ed.putString("username", username_entered);
			ed.putString("password", password_entered);
			ed.putString("name", name_entered);
			ed.putString("email", email_entered);
			ed.putLong("phone", Long.parseLong(phone_entered));
			ed.putString("credit",credit_entered);
			ed.putBoolean("login_status", false);
			String currentuservalues=username_entered+","+password_entered+","+name_entered+","+email_entered+","+phone_entered+","+credit_entered;

			if(! sp.getString("previous_registrations", "").equals("")){
				//already some registered
				currentuservalues=sp.getString("previous_registrations", "") + "|" +currentuservalues;
			}
			ed.putString("previous_registrations", currentuservalues);
			ed.commit();
			Toast.makeText(getApplicationContext(), "Registered Succesfully. \n Please login to continue", Toast.LENGTH_LONG).show();
			System.out.println("----------------------------------------\n"+sp.getString("previous_registrations", "ONNNUM ILLA")+"\n-------------------------------------------------");

			startActivity(new Intent(this, LoginActivity.class));
			finish();
		}

	}
	//	public void login(View v)
	//	{
	//	//	startActivity(new Intent(this, RegisterActivity.class));
	//	}
}
