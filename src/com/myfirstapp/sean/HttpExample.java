package com.myfirstapp.sean;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

public class HttpExample extends Activity {

	TextView httpTV;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
		StrictMode.setThreadPolicy(policy);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpex);
		
        httpTV = (TextView) findViewById(R.id.tvHttp);
        new LoadData().execute();
	}
	
	class LoadData extends AsyncTask<String, Void, String>{
        String returned;
 
        protected String doInBackground(String... urls){
            GetMethodEx test = new GetMethodEx();
            try{
                returned = test.getInternetData();
            } catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }// doInBackground
 
        @Override
        protected void onPostExecute(String result){
            httpTV.setText(returned);
        }
    }
}
