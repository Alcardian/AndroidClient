package org.lindholmen.errorgroup.errorstock;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
/**
 * 
 * @author Sebastian Potter, also known as Alcardian.
 *
 */
public class ALC_PieChart {
	/**
	 * 
	 * @param context
	 * @param title Title of chart
	 * @param series All the values for the chart
	 * @param colors Colors to be used for the chart
	 * @return
	 */
	public Intent getIntent(Context context, String title, CategorySeries series, int[] colors){
		/**int[] values = {1,2,3,4,5};
		CategorySeries series = new CategorySeries("Pie Chart");
		int k=0;
		for(int value:values){
			series.add("Section " + ++k, value);
		}*/
		
		//int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.GRAY, Color.RED, Color.CYAN };
		
		DefaultRenderer renderer = new DefaultRenderer();
		/**
		for (int color : colors) {
			SimpleSeriesRenderer r = new SimpleSeriesRenderer();
			r.setColor(color);
			renderer.addSeriesRenderer(r);
		}*/
		for(int i=0; i<series.getItemCount(); i++){
			SimpleSeriesRenderer r = new SimpleSeriesRenderer();
			r.setColor(colors[i]);
			renderer.addSeriesRenderer(r);
		}
		
		//renderer.setChartTitle("Pie Chart Test");
		renderer.setLabelsColor(Color.BLACK);
		renderer.setChartTitleTextSize(12);
		renderer.setZoomButtonsVisible(true);

		Intent intent = ChartFactory.getPieChartIntent(context, series, renderer, title);
		return intent;
	}
}
