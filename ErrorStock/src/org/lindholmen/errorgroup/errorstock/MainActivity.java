package org.lindholmen.errorgroup.errorstock;

import org.achartengine.model.CategorySeries;
import org.achartengine.model.TimeSeries;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/**@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/

	public void LineGraphhandler(View view) {
		//
		int[] x = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // x values!
		double[] y =  { 903.11, 876.39, 872.35, 871.99, 1011.41, 1015.20, 1027.04, 1016.03 ,1033.56 ,1022.31 }; // y values!
		TimeSeries series = new TimeSeries("Closing Price(?)");
		//
		for(int i=0; i<x.length; i++){
			series.add(x[i], y[i]);
		}
		
		
		LineChart line = new LineChart();
		Intent lineIntent = line.getIntent(this, "Line Chart", series, Color.RED);
		startActivity(lineIntent);
	}
	public void PieGraphhandler(View view) {
		//
		int[] values = {1,2,3,4,5};
		CategorySeries series = new CategorySeries("Pie Chart");
		int k=0;
		for(int value:values){
			series.add("Section " + ++k, value);
		}
		int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.GRAY, Color.RED, Color.CYAN };
		//
		
		PieChart pie = new PieChart();
		Intent pieIntent = pie.getIntent(this, "Pie Chart", series, colors);
		startActivity(pieIntent);
	}
	public void ChandleGraphhandler(View view) {
		CandleChart candle = new CandleChart();
		Intent candleIntent = candle.getIntent(this);
		startActivity(candleIntent);
		
		/**TemperatureChart candle = new TemperatureChart();
		Intent candleIntent = candle.execute(this);
		startActivity(candleIntent);*/
	}
	public void Newshandler(View view) {

	}
}
