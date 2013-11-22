package org.lindholmen.errorgroup.errorstock;

import android.content.Context;
import android.content.Intent;
import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class LineChart{
	public Intent getIntent(Context context, String title, TimeSeries series, int color){
		
		//Add the TimeSeries to a MultipleSeriesDataset
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		dataset.addSeries(series);
		
		//Renderer
		XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
		XYSeriesRenderer renderer = new XYSeriesRenderer();
		renderer.setColor(color);
		
		
		//For Demo
		mRenderer.setAntialiasing(true);
		mRenderer.setXLabels(0);
		mRenderer.addXTextLabel(1, "2013-09-16");
		mRenderer.addXTextLabel(2, "2013-09-23");
		mRenderer.addXTextLabel(3, "2013-09-30");
		mRenderer.addXTextLabel(4, "2013-10-07");
		mRenderer.addXTextLabel(5, "2013-10-14");
		mRenderer.addXTextLabel(6, "2013-10-21");
		mRenderer.addXTextLabel(7, "2013-10-28");
		mRenderer.addXTextLabel(8, "2013-11-04");
		mRenderer.addXTextLabel(9, "2013-11-11");
		mRenderer.addXTextLabel(10, "2013-11-18");
		mRenderer.setXAxisMax(8);
		mRenderer.setDisplayValues(true);
		renderer.setPointStyle(PointStyle.DIAMOND);
		renderer.setDisplayChartValues(true);
		renderer.setFillPoints(true);
		//mRenderer.setXAxisMax(5);
		//mRenderer.clearXTextLabels();
		//
		
		mRenderer.addSeriesRenderer(renderer);
		mRenderer.setZoomButtonsVisible(true);
		
		Intent intent = ChartFactory.getLineChartIntent(context, dataset, mRenderer, title);
		return intent;
	}
}
