package de.jonas.schroeter.lib;

import javafx.scene.chart.BarChart;

/**
 * Created by Jonas Schroeter on 21.04.2018 for "GraphLib".
 */
public class ChartSpecs {

    private String name;
    private String xAxisName = "";
    private String yAxisName = "";
    private double boundsX;
    private double boundsY;
    private String[] seriesNames;
    private String id;

    public ChartSpecs(String name, String xAxisName, String yAxisName, double boundsX, double boundsY, String id, String... seriesNames){
        this.name = name;
        this.xAxisName = xAxisName;
        this.yAxisName = yAxisName;
        this.boundsX = boundsX;
        this.boundsY = boundsY;
        this.seriesNames = seriesNames;
        this.id = id;
    }
    public ChartSpecs(String name, double boundsX, double boundsY, String id){
        this.name = name;
        this.boundsX = boundsX;
        this.boundsY = boundsY;
        this.id = id;
    }
    public ChartSpecs(String name, String id){
        this.name = name;
        this.id = id;
    }

    String getName() {
        return name;
    }

    String getxAxisName() {
        return xAxisName;
    }

    String getyAxisName() {
        return yAxisName;
    }

    double getBoundsX() {
        return boundsX;
    }

    double getBoundsY() {
        return boundsY;
    }

    String getSeriesNameAt(int index){
        try{
            return seriesNames[index];
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("WARN: Series names are not specified");
            return "Value";
        }
    }

    String getID(){
        return id;
    }
}
