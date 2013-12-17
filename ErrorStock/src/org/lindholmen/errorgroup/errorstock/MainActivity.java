package org.lindholmen.errorgroup.errorstock;

import java.util.ArrayList;

import org.achartengine.model.CategorySeries;
import org.achartengine.model.TimeSeries;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;

/**
 * 
 * @author Sebastian Potter, also known as Alcardian.
 * 
 */
public class MainActivity extends Activity {
	public static String[] date = {};
	public static int[] volume = {};
	public static double[] opening = {};
	public static double[] closing = {};
	public static double[] high = {};
	public static double[] low = {};
	public static String[] textNews = {};
	public static String dateFrom;
	public static String dateTo;
	// public static boolean dailyData; // true = daily data, false = weekly
	// data

	public EditText stockNameField;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dateFrom = "0"; // 0 = no date set
		dateTo = "0";
		// dailyData = false;

		stockNameField = (EditText) findViewById(R.id.editText1);

		// loadTestData1();

	}

	/**
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 *           menu; this adds items to the action bar if it is present.
	 *           getMenuInflater().inflate(R.menu.main, menu); return true; }
	 */

	public void LineGraphhandler(View view) {
		TimeSeries[] series = { createTimeSeries(opening, "Opening Price"),
				createTimeSeries(closing, "Closing Price"),
				createTimeSeries(high, "Highest Price"),
				createTimeSeries(low, "Lowest Price") };
		ALC_LineChart line = new ALC_LineChart();
		int[] color = { Color.RED, Color.BLUE, Color.MAGENTA, Color.CYAN };
		Intent lineIntent = line.getIntent(this, "Line Chart", series, color,
				date);
		startActivity(lineIntent);
	}

	public void PieGraphhandler(View view) {
		int[] values = getPieVolume();
		CategorySeries series = new CategorySeries("Pie Chart");
		String[] names = getPieDate();
		for (int i = 0; i < values.length; i++) {
			series.add(names[i], values[i]);
		}

		int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.GRAY,
				Color.RED, Color.CYAN, Color.BLACK, Color.parseColor("#FFA500") };
		//

		ALC_PieChart pie = new ALC_PieChart();
		Intent pieIntent = pie.getIntent(this, "Pie Chart", series, colors);
		startActivity(pieIntent);
	}

	public void ChandleGraphhandler(View view) {
		ALC_VRangeChart candle = new ALC_VRangeChart();
		Intent vRangeIntent = candle.getIntent(this, "Vertical Range Chart",
				low, high, date);
		startActivity(vRangeIntent);
	}

	/**
	 * public void VerticalRangeBhanddler(View view) { CandleChart candle = new
	 * CandleChart(); Intent candleIntent = candle.getIntent(this,
	 * "Vertical Range Chart", low, high, date); startActivity(candleIntent); }
	 */
	public void CandlestickHandler(View view) {
		startActivity(new Intent(this, CandlestickChart.class));
	}

	public void Newshandler(View view) {
		startActivity(new Intent(this, ALC_NewsViewer.class));
	}

	/**
	 * Action Listener that gets the data when the button is pressed.
	 * 
	 * @param view
	 */
	public void FindButtonhandler(View view) {
		System.out.println("Getting new stock data");
		if (stockNameField.getText().toString().equals("0")) { // load test data
			loadTestData1();
			// System.out.println("");
		} else {

		}
		sortStoredData();
	}

	public void Timehandler(View view) {
		startActivity(new Intent(this, TimeSettings.class));
	}

	public static void loadTestData1() {
		String[] datex = { "2013-09-16", "2013-09-23", "2013-09-30",
				"2013-10-07", "2013-10-14", "2013-10-21", "2013-10-28",
				"2013-11-04", "2013-11-11", "2013-11-18" };
		int[] volumex = { 2094700, 1486300, 1675500, 1910500, 4133200, 2524500,
				1397500, 1240700, 1270600, 1279900 };
		double[] openingx = { 896.20, 896.15, 869.08, 867.45, 866.66, 1011.46,
				1015.20, 1031.50, 1009.51, 1035.75 };
		double[] closingx = { 903.11, 876.39, 872.35, 871.99, 1011.41, 1015.20,
				1027.04, 1016.03, 1033.56, 1022.31 };
		double[] highx = { 905.99, 901.59, 894.10, 873.99, 1015.46, 1040.57,
				1041.52, 1032.37, 1039.75, 1048.74 };
		double[] lowx = { 881.00, 871.31, 868.31, 842.98, 865.39, 995.79,
				1012.99, 1007.64, 1005.00, 1020.36 };
		String[] textNewsx = {
				"2013-12-02: The news information are now stored in the main data storage of the application!",
				"2013-11-29: A lot of different charts are now complete!",
				"2013-11-22: something somthing...", "2013-11-15: :3",
				"2013-11-15: Will", "2013-11-14: see", "2013,11,13: if",
				"2013,11-12: the", "2013-11-11: scrollbar", "2013-11-10: works" };
		date = datex;
		volume = volumex;
		opening = openingx;
		closing = closingx;
		high = highx;
		low = lowx;
		textNews = textNewsx;
	}

	public static void sortStoredData() {
		// System.out.println("-Sorting data-");
		// dates within time frame
		/**
		 * public static String[] date; public static int[] volume; public
		 * static double[] opening; public static double[] closing; public
		 * static double[] high; public static double[] low;
		 */
		ArrayList<String> datex = new ArrayList<String>();
		ArrayList<Integer> volumex = new ArrayList<Integer>();
		ArrayList<Double> openingx = new ArrayList<Double>();
		ArrayList<Double> closingx = new ArrayList<Double>();
		ArrayList<Double> highx = new ArrayList<Double>();
		ArrayList<Double> lowx = new ArrayList<Double>();

		for (int i = 0; i < date.length; i++) {
			datex.add(date[i]);
			volumex.add(volume[i]);
			openingx.add(opening[i]);
			closingx.add(closing[i]);
			highx.add(high[i]);
			lowx.add(low[i]);
		}
		if (!dateFrom.equals("0")) { // Do this if we are to sort within a time
										// frame
			// System.out.println("-A Date Is Set-");
			int iFrom = dateToInt(dateFrom); // from date in int
			int iTo = dateToInt(dateTo); // to date in int
			for (int i = 0; i < datex.size(); i++) {
				int iDate = dateToInt(datex.get(i)); // date in int
				if (iDate <= iTo && iDate >= iFrom) { // if date is lessOrEqual
														// to toDate AND date is
														// greaterOrEqual to
														// fromDate
					// && iDate >= iFrom

				} else { // else the date is bad, remove it and put i one step
							// back
					// System.out.println("-Removed something...-");
					datex.remove(i);
					volumex.remove(i);
					openingx.remove(i);
					closingx.remove(i);
					highx.remove(i);
					lowx.remove(i);
					i--;
				}
			}
		}

		// sort in order
		// weekly setting if applied

		// Done, now place the sorted values back
		date = new String[datex.size()];
		volume = new int[volumex.size()];
		opening = new double[openingx.size()];
		closing = new double[closingx.size()];
		high = new double[highx.size()];
		low = new double[lowx.size()];

		for (int i = 0; i < datex.size(); i++) {
			date[i] = datex.get(i);
			volume[i] = volumex.get(i);
			opening[i] = openingx.get(i);
			closing[i] = closingx.get(i);
			high[i] = highx.get(i);
			low[i] = lowx.get(i);
		}
		System.out.println("-Done Sorting-");
	}

	public static int dateToInt(String aDate) {
		String[] temp1 = aDate.split("-"); // turns example 2013-11-15 to 2013,
											// 11, 15
		String temp2 = temp1[0] + temp1[1] + temp1[2]; // puts the parts
														// together into if we
														// follow example
														// 20131115
		int temp3 = Integer.parseInt(temp2); // turns the example string into
												// number 20131115
		return temp3;
	}

	public TimeSeries createTimeSeries(double[] y, String title) {
		// int[] x = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // x values!
		// double[] y = { 903.11, 876.39, 872.35, 871.99, 1011.41, 1015.20,
		// 1027.04, 1016.03 ,1033.56 ,1022.31 }; // y values!
		TimeSeries series = new TimeSeries(title);
		//
		for (int i = 0; i < y.length; i++) {
			series.add(i, y[i]);
		}
		return series;
	}

	public int[] getPieVolume() {
		// int[] temp = {volume[0], volume[1], volume[2], volume[3], volume[4],
		// volume[5], volume[6]};
		int[] temp;
		if (volume.length >= 7) { // if we have 7 or more values in the volume,
									// use 7
			temp = new int[7];
		} else { // else use the number we have
			temp = new int[volume.length];
		}

		for (int i = 0; i < temp.length; i++) {
			temp[i] = volume[i];
		}

		return temp;
	}

	public String[] getPieDate() {
		// String[] temp = {date[0], date[1], date[2], date[3], date[4],
		// date[5], date[6]};
		String temp[];
		if (date.length >= 7) {
			temp = new String[7];
		} else {
			temp = new String[date.length];
		}

		for (int i = 0; i < temp.length; i++) {
			temp[i] = date[i];
		}

		return temp;
	}
}
