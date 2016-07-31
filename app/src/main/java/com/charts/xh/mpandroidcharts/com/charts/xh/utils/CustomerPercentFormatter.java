package com.charts.xh.mpandroidcharts.com.charts.xh.utils;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by xiehui on 2016/7/31.
 */
public class CustomerPercentFormatter  implements ValueFormatter, YAxisValueFormatter {

        protected DecimalFormat mFormat;
        protected List<String> mXVals;
        public CustomerPercentFormatter(ChartData data) {
            mFormat = new DecimalFormat("###,###,##0.0");
            mXVals=data.getXVals();
        }

        /**
         * Allow a custom decimalformat
         *
         * @param format
         */
        public CustomerPercentFormatter(DecimalFormat format) {
            this.mFormat = format;
        }

        // ValueFormatter
        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return mXVals.get(entry.getXIndex())+" : "+mFormat.format(value) + " %";

        }

        // YAxisValueFormatter
        @Override
        public String getFormattedValue(float value, YAxis yAxis) {
            return mFormat.format(value) + " %";
        }


}
