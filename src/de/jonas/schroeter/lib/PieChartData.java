package de.jonas.schroeter.lib;

import java.util.Arrays;

/**
 * Created by Jonas Schroeter on 21.04.2018 for "GraphLib".
 */
public class PieChartData {

    private String[] names;
    private double[] values;

    public PieChartData(Object[][] data){
        names = Arrays.asList(data[0]).toArray(new String[]{});
        values = new double[data[1].length];
        for(int i = 0; i < data[1].length; i++){
            values[i] = Double.parseDouble(String.valueOf(data[1][i]));
        }
        double x = 0;
        for(double d : values)if((x += d) > 100){System.err.println("WARN: Chart over 100%"); break;};
    }
    public String[] getNames() {
        return names;
    }

    public double[] getValues() {
        return values;
    }
}
