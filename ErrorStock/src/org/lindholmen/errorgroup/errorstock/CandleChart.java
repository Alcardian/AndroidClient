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

public class CandleChart {
	public Intent getIntent(Context context) {
	    //double[] minValues = new double[] { -24, -19, -10, -1, 7, 12, 15, 14, 9, 1, -11, -16 };
	    double[] minValues = new double[] { 2, 4, 6, 8, 7, 12, 15, 14, 9, 1, 9, 7 };
	    double[] maxValues = new double[] { 7, 12, 24, 28, 33, 35, 37, 36, 28, 19, 13, 17 };

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
	    
	    //
	    //XYMultipleSeriesRenderer mrenderer = buildBarRenderer(colors);
	    XYMultipleSeriesRenderer mrenderer = new XYMultipleSeriesRenderer();
	    mrenderer.setAxisTitleTextSize(16);
	    mrenderer.setChartTitleTextSize(20);
	    mrenderer.setLabelsTextSize(15);
	    mrenderer.setLegendTextSize(15);
	    
	    SimpleSeriesRenderer sr = new SimpleSeriesRenderer();
	    sr.setColor(colors[0]);
	    mrenderer.addSeriesRenderer(sr);
	    
	    
	    //
	    //setChartSettings(mrenderer, "Monthly temperature range", "Month", "Celsius degrees", 0.5, 12.5,
	    //    -30, 45, Color.GRAY, Color.LTGRAY);
	    //mrenderer.setChartTitle("A Title");
	    mrenderer.setXTitle("X is here");
	    mrenderer.setYTitle("Y is here");
	    //mrenderer.setXAxisMin(minValues.length);
	    
	    mrenderer.setZoomButtonsVisible(true);
	    
	    mrenderer.setBarSpacing(0.5);
	    mrenderer.setXLabels(10);
	    mrenderer.setYLabels(10);
	    //mrenderer.addXTextLabel(1, "Jan(1)");
	    //mrenderer.addXTextLabel(3, "Mar(3)");
	    //mrenderer.addXTextLabel(5, "May(5)");
	    //mrenderer.addXTextLabel(7, "Jul(7)");
	    //mrenderer.addXTextLabel(10, "Oct(10)");
	    //mrenderer.addXTextLabel(12, "Dec(12)");
	    /**renderer.addYTextLabel(-25, "Very cold");
	    renderer.addYTextLabel(-10, "Cold");
	    renderer.addYTextLabel(5, "OK");
	    renderer.addYTextLabel(20, "Nice");*/
	    mrenderer.setMargins(new int[] {30, 70, 10, 0});
	    mrenderer.setYLabelsAlign(Align.RIGHT);
	    SimpleSeriesRenderer r = mrenderer.getSeriesRendererAt(0);
	    r.setDisplayChartValues(true);
	    r.setChartValuesTextSize(12);
	    r.setChartValuesSpacing(3);
	    //r.setGradientEnabled(true);
	    //r.setGradientStart(-20, Color.BLUE);
	    //r.setGradientStop(20, Color.GREEN);
	    return ChartFactory.getRangeBarChartIntent(context, dataset, mrenderer, Type.DEFAULT,
	        "Candle Chart");
	  }
}
