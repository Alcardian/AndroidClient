package org.lindholmen.errorgroup.errorstock;

import android.content.Context;
import android.content.Intent;
import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
/**
 * 
 * @author Sebastian Potter, also known as Alcardian.
 *
 */
public class ALC_LineChart{
	public Intent getIntent(Context context, String title, TimeSeries[] series, int color[], String[] xTitles){
		
		//Add the TimeSeries to a MultipleSeriesDataset
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		/**for(int i=0; i<series.length; i++){
			dataset.addSeries(series[i]);
		}*/
		for(int i=0; i<series.length; i++){
			dataset.addSeries(series[i]);
		}
		
		//Renderer
		XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
		XYSeriesRenderer[] renderer = {new XYSeriesRenderer(), new XYSeriesRenderer(), new XYSeriesRenderer(), new XYSeriesRenderer()};
		
		mRenderer.setAntialiasing(true);
		mRenderer.setXLabels(0);
		
		for(int i=0; i<xTitles.length; i++){
			mRenderer.addXTextLabel(i, xTitles[i]);
		}
		
		mRenderer.setXAxisMax(7);
		mRenderer.setDisplayValues(true);
		//mRenderer.setXLabelsAngle(90);
	    //mRenderer.setXLabelsAlign(Align.LEFT);
		
		for(int i=0; i<series.length; i++){
			renderer[i].setPointStyle(PointStyle.DIAMOND);
			renderer[i].setDisplayChartValues(true);
			renderer[i].setFillPoints(true);
			renderer[i].setColor(color[i]);
			mRenderer.addSeriesRenderer(renderer[i]);
		}
		mRenderer.setZoomButtonsVisible(true);
		
		Intent intent = ChartFactory.getLineChartIntent(context, dataset, mRenderer, title);
		return intent;
	}
}
