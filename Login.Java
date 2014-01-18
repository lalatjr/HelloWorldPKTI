package com.example.mk_00;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends Activity {
	
	EditText un , pw;
	TextView error;
	Button login,cancel,daftar;
	String i;
	private String url ="http://10.0.2.2/android/login.php";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		un=(EditText)findViewById(R.id.us);
		
		pw=(EditText)findViewById(R.id.pa);
		
		login=(Button)findViewById(R.id.login);
		
		error=(TextView)findViewById(R.id.tv_error);
		
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
			
			postParameters.add(new BasicNameValuePair("username", un.getText().toString()));
			
			postParameters.add(new BasicNameValuePair("password" , pw.getText().toString()));
			
			String response= null;
			try{
				response=Sambung1.eksekusiHttpPost(url, postParameters);
				
				String res=response.toString();
				res=res.trim();
				res=res.replaceAll("\\s+", "");
				error.setText(res);
				if(res.equals("1")){
					error.setText("Correct Username and Password");
					berhasil(v);
				}
				else{
					error.setText("Username/Password Salah");
				}
			}
			catch(Exception e){
				un.setText(e.toString());
			}
			}
		});
		}
	public void tambah_user(View theButton){
		Intent i = new Intent (this,Daftar.class);
		startActivity(i);
	}
	public void berhasil(View theButton){
		Intent s=  new Intent(this,menu.class);
		startActivity(s);
	}
}
