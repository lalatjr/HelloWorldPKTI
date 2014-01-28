package com.example.mk_00;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;;


public class Sambung extends Activity implements OnClickListener{
	Button lButton,dButton,exit;
	EditText user,pass;
	TextView status;

	private String url ="http://10.0.2.2/android/login.php";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		user = (EditText) findViewById(R.id.in_id);
		pass = (EditText) findViewById(R.id.in_pass);
		status = (TextView) findViewById(R.id.status);
		lButton = (Button) findViewById(R.id.login);
		
		dButton=(Button)findViewById(R.id.daftar);
		dButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View daftar) {
				// TODO Auto-generated method stub
				Intent daf= new Intent(daftar.getContext(),Daftar.class);
				startActivityForResult(daf, 0);
			}
		});
		
		lButton.setOnClickListener(this);		
		}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		kirimData();
	}
	private void kirimData(){
		// TODO Auto-generated method stub
		ArrayList<NameValuePair> kirim= new ArrayList<NameValuePair>();
		kirim.add(new BasicNameValuePair("auser",user.getText().toString()));
		kirim.add(new BasicNameValuePair("apass",pass.getText().toString()));
		String respon = null;
		try {
			respon = Sambung1.eksekusiHttpPost(url,kirim);
			String res =respon.toString();
			res = res.trim();
			res=res.replaceAll("\\s+", "");
			
			if(res.equals("1")){
			status.setText("Correct Username and Password");
			berhasil();
			}
			else{
				status.setText("Username/Password Salah");
			}
				
		} catch (Exception e){
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		}
	public void berhasil(){
		Intent s= new Intent(this,list.class);
		startActivity(s);
	}
	}