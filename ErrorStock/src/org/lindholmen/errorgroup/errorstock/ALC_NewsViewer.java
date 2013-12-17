package org.lindholmen.errorgroup.errorstock;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 
 * @author Sebastian Potter, also known as Alcardian.
 *
 */
public class ALC_NewsViewer extends Activity{
	TextView newsText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_viewer);
		
		newsText = (TextView) findViewById(R.id.news_text);
		
		newsText.setText("");
		
		if(MainActivity.textNews.length == 0){	//if there are no news for specified stock.
			newsText.append("No news Available. \n");
		}else{
			newsText.append(getNewsData());
		}
		
		/**
		if(MainActivity.textNews.length == 0){	//if there are no news for specified stock.
			newsText.append("No news Available. \n");
		}
		for(int i=0; i<MainActivity.textNews.length; i++){
			newsText.append(MainActivity.textNews[i] + "\n");
		}
		*/
	}
	
	public String getNewsData(){
		String temp = "";
		for(int i=0; i<MainActivity.textNews.length; i++){
			temp += (MainActivity.textNews[i] + "\n");	//Add next news to the string
		}
		return temp;
	}
}
