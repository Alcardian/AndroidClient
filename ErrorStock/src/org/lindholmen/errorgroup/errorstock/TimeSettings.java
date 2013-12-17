package org.lindholmen.errorgroup.errorstock;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/**
 * 
 * @author Sebastian Potter, also known as Alcardian.
 *
 */
public class TimeSettings extends Activity{
	EditText textFrom, textTo;
	TextView statusText;
	//Button updateButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time_settings);
		
		textFrom = (EditText) findViewById(R.id.time_fromText);
		textTo = (EditText) findViewById(R.id.time_toText);
		statusText = (TextView) findViewById(R.id.time_status_text);
		//updateButton = (Button) findViewById(R.id.time_updateButton);
	}
	
	public void updateButtonHandler(View view) {
		
		statusText.setText("From: " + textFrom.getText().toString() + ", To: " + textTo.getText().toString());
		MainActivity.dateFrom = textFrom.getText().toString();
		MainActivity.dateTo = textTo.getText().toString();
		if(textFrom.getText().toString().equals("")){
			MainActivity.dateFrom = "0";
			MainActivity.dateTo = "0";
		}
		MainActivity.sortStoredData();
		/**
		if(true){	//if we have from date
			MainActivity.dateFrom = "";
		}
		if(true){	//if we have a to date
			MainActivity.dateTo = "";
		}*/
	}
}
