package org.lindholmen.errorgroup.errorstock;

import org.stockchart.StockChartActivity;
import org.stockchart.core.Area;
import org.stockchart.core.Axis.Side;
import org.stockchart.series.StockSeries;

import android.os.Bundle;
/**
 * 
 * @author Sebastian Potter, also known as Alcardian.
 *
 */
public class CandlestickChart extends StockChartActivity{
	private StockSeries dataSeries;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		populateChart();
		
		this.getStockChartView().invalidate();
	}

	@Override
	protected void initChart() {
		dataSeries = new StockSeries();
		dataSeries.setName("price");
		dataSeries.setYAxisSide(Side.LEFT);
		
		Area a = this.getStockChartView().addArea();
		
		a.getSeries().add(dataSeries);
	}

	
	@Override
	protected void restoreChart() {
		//dataSeries = (StockSeries) this.getStockChartView().findSeriesByName("price");
	}
	
	private void populateChart()
	{
		//dataSeries.addPoint(80, 500, 60, 200);	//opening, higher, lower, closing
		for(int i=0; i<MainActivity.date.length; i++){
			dataSeries.addPoint(MainActivity.opening[i], MainActivity.high[i], MainActivity.low[i], MainActivity.closing[i]);
		}
	}

}
