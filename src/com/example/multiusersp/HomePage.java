package com.example.multiusersp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.media.audiofx.AcousticEchoCanceler;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends ActionBarActivity {
	public static String name="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		//SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		
	}
	public void accountClicked(View v) {
		Toast.makeText(getApplicationContext(), "clicked",Toast.LENGTH_SHORT).show();
		startActivity(new Intent(this, Account_details.class));
		
	}

}
	

