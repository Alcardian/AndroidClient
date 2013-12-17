package org.lindholmen.errorgroup.errorstock;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.RangeCategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint.Align;
/**
 * 
 * @author Sebastian Potter, also known as Alcardian.
 *
 */
public class ALC_VRangeChart {
	public Intent getIntent(Context context, String title, double[] minValues, double[] maxValues, String[] date) {

	    XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
	    //RangeCategorySeries series = new RangeCategorySeries("Temperature");
	    RangeCategorySeries series = new RangeCategorySeries("");
	    int length = minValues.length;
	    for (int k = 0; k < length; k++) {
	      series.add(minValues[k], maxValues[k]);
	    }
	    dataset.addSeries(series.toXYSeries());
	    //int[] colors = new int[] { Color.CYAN };
	    int[] colors = new int[] { Color.BLACK };
	    
	    XYMultipleSeriesRenderer mrenderer = new XYMultipleSeriesRenderer();
	    mrenderer.setAxisTitleTextSize(16);
	    mrenderer.setChartTitleTextSize(20);
	    mrenderer.setLabelsTextSize(12);
	    mrenderer.setLegendTextSize(15);
	    
	    SimpleSeriesRenderer sr = new SimpleSeriesRenderer();
	    sr.setColor(colors[0]);
	    mrenderer.addSeriesRenderer(sr);
	    
	    //mrenderer.setXTitle("X is here");
	    //mrenderer.setYTitle("Y is here");
	    //mrenderer.setXAxisMin(minValues.length);
	    mrenderer.setXLabelsAngle(270);
	    mrenderer.setXLabelsAlign(Align.RIGHT);
	    mrenderer.setZoomButtonsVisible(true);
	    
	    mrenderer.setBarSpacing(0.5);
	    mrenderer.setXLabels(0);
	    mrenderer.setYLabels(10);
	    mrenderer.setYLabelsPadding(10);
	    
	    for(int i=0; i<date.length; i++){
	    	mrenderer.addXTextLabel(i, date[i]);
	    }
	    
	    mrenderer.setMargins(new int[] {30, 50, 10, 0});
	    mrenderer.setYLabelsAlign(Align.RIGHT);
	    SimpleSeriesRenderer r = mrenderer.getSeriesRendererAt(0);
	    r.setDisplayChartValues(true);
	    r.setChartValuesTextSize(12);
	    r.setChartValuesSpacing(3);
	    return ChartFactory.getRangeBarChartIntent(context, dataset, mrenderer, Type.DEFAULT,
	        title);
	  }
}
