package com.myfirstapp.sean;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteExample extends Activity implements OnClickListener {
	
	Button sqlUpdate, sqlView, sqlModify, sqlGetInfo, sqlDelete;
	EditText sqlName, sqlRating, sqlRow;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqliteexample);
		
		sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
		sqlView = (Button) findViewById(R.id.bSQLopenView);
		sqlModify = (Button) findViewById(R.id.bSQLmodify);
		sqlGetInfo = (Button) findViewById(R.id.bgetInfo);
		sqlDelete = (Button) findViewById(R.id.bSQLdelete);
		
		sqlName = (EditText) findViewById(R.id.etSQLName);
		sqlRating = (EditText) findViewById(R.id.etSQLRating);
		sqlRow = (EditText) findViewById(R.id.etSQLrowInfo);
		
		sqlView.setOnClickListener(this);
		sqlUpdate.setOnClickListener(this);	
		sqlModify.setOnClickListener(this);	
		sqlGetInfo.setOnClickListener(this);
		sqlDelete.setOnClickListener(this);		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
			case R.id.bSQLUpdate:
				boolean didItWork = true;
				
				try {
					String name = sqlName.getText().toString();
					String rating = sqlRating.getText().toString();
					
					GoodOrBad entry = new GoodOrBad(SQLiteExample.this);
					entry.open();
					entry.createEntry(name, rating);
					entry.close();
				} catch (Exception e) {
					didItWork = false;
					String error = e.toString();						
					Dialog d = new Dialog(this);
					d.setTitle("Epic Fail!");
					TextView tv = new TextView(this);
					tv.setText(error);
					d.setContentView(tv);
					d.show();
				} finally {
					if (didItWork) {
						Dialog d = new Dialog(this);
						d.setTitle("Yeah Bitch!!!");
						TextView tv = new TextView(this);
						tv.setText("Success");
						d.setContentView(tv);
						d.show();
					}
				}
				break;
				
			case R.id.bSQLopenView:
				try {
					Intent i = new Intent("com.myfirstapp.sean.SQLVIEW");
					startActivity(i);
				} catch (Exception e) {
					String error = e.toString();						
					Dialog d = new Dialog(this);
					d.setTitle("Epic Fail!");
					TextView tv = new TextView(this);
					tv.setText(error);
					d.setContentView(tv);
					d.show();
				}
				break;
				
			case R.id.bgetInfo:
				try {	
					String s = sqlRow.getText().toString();
					long l = Long.parseLong(s);
					
					GoodOrBad gob = new GoodOrBad(this);
					gob.open();
					String returnedName = gob.getName(l); 
					String returnedRating = gob.getRating(l);
					gob.close();
					
					sqlName.setText(returnedName);
					sqlRating.setText(returnedRating);
				} catch (Exception e) {
					String error = e.toString();						
					Dialog d = new Dialog(this);
					d.setTitle("Epic Fail!");
					TextView tv = new TextView(this);
					tv.setText(error);
					d.setContentView(tv);
					d.show();
				}
				break;
				
			case R.id.bSQLmodify:
				try {
					String mName = sqlName.getText().toString();
					String mRating = sqlRating.getText().toString();
					String mRow = sqlRow.getText().toString();
					long lRow = Long.parseLong(mRow);
					
					GoodOrBad ex = new GoodOrBad(this);
					ex.open();
					ex.updateEntry(lRow, mName, mRating);
					ex.close();
				} catch (Exception e) {
					String error = e.toString();						
					Dialog d = new Dialog(this);
					d.setTitle("Epic Fail!");
					TextView tv = new TextView(this);
					tv.setText(error);
					d.setContentView(tv);
					d.show();
				}
				break;
				
			case R.id.bSQLdelete:
				try {
					String dRow = sqlRow.getText().toString();
					long lRow1 = Long.parseLong(dRow);
	
					GoodOrBad ex1 = new GoodOrBad(this);
					ex1.open();
					ex1.deleteEntry(lRow1);
					ex1.close();
				} catch (Exception e) {
					String error = e.toString();						
					Dialog d = new Dialog(this);
					d.setTitle("Epic Fail!");
					TextView tv = new TextView(this);
					tv.setText(error);
					d.setContentView(tv);
					d.show();
				}
				break;
		}
	}
}
