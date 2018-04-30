package de.jonas.schroeter.lib;

import javafx.scene.chart.*;
import javafx.scene.layout.Pane;

/**
 * Created by Jonas Schroeter on 21.04.2018 for "GraphLib".
 */
public class GraphLib {

    @SafeVarargs
    public static <T> void createChart(GraphType type, Pane root, ChartSpecs specs, GraphData<T>... data){

        for(int i = 1; i < data.length; i++){
            if(data[i].getType() != data[i - 1].getType()){
                System.err.println("WARN: Data types are not the same");
            }
        }

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel(specs.getxAxisName());

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(specs.getyAxisName());

        XYChart chart;
        switch(type){
            case BARCHART:
                chart = new BarChart<>(xAxis, yAxis);
                break;
            case LINECHART:
                chart = new LineChart<>(xAxis, yAxis);
                break;
            case SCATTEREDCHART:
                chart = new ScatterChart<>(xAxis, yAxis);
                break;
            case BUBBLECHART:
                NumberAxis newXAxis = new NumberAxis();
                newXAxis.setLabel(specs.getxAxisName());
                chart = new BubbleChart<>(newXAxis, yAxis);
                break;
            case AREACHART:
                chart = new AreaChart<>(xAxis, yAxis);
                break;
            default:
                chart = new BarChart<>(xAxis, yAxis);
                break;
        }
        chart.setTitle(specs.getName());
        chart.setId(specs.getID());
        if(specs.getBoundsX() != 0){
            chart.setPrefSize(specs.getBoundsX(), specs.getBoundsY());
        }
        else {
            System.err.println("WARN: Graph bounds not set");
        }

        for(int i = 0; i < data.length; i++){
            GraphData<T> gd = data[i];
            XYChart.Series series = new XYChart.Series();
            for(int j= 0; j < gd.getDataX().length; j++){
                if(!type.isSpecial()){
                    series.getData().add(new XYChart.Data(String.valueOf(gd.getDataX()[j]), gd.getDataY()[j]));
                }
                else if(type == GraphType.BUBBLECHART){
                    series.getData().add(new XYChart.Data(gd.getDataX()[j], gd.getDataY()[j]));
                }
            }
            series.setName(specs.getSeriesNameAt(i));
            chart.getData().add(series);
        }
        root.getChildren().add(chart);
    }

    public static <T> void createChart(GraphType type, Pane root, ChartSpecs specs, PieChartData data){
        PieChart chart = new PieChart();
        if(specs.getBoundsX() != 0){
            chart.setPrefSize(specs.getBoundsX(), specs.getBoundsY());
        }
        else {
            System.err.println("WARN: Graph bounds not set");
        }
        chart.setTitle(specs.getName());
        chart.setId(specs.getID());
        for(int i = 0; i < data.getNames().length; i++){
            chart.getData().add(new PieChart.Data(data.getNames()[i], data.getValues()[i]));
        }

        root.getChildren().add(chart);
    }
}
