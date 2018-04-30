package de.jonas.schroeter.tests;

import de.jonas.schroeter.lib.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Jonas Schroeter on 21.04.2018 for "GraphLib".
 */
public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Pane root = new Pane();
        Scene scene = new Scene(root, 1600, 900);
        primaryStage.setScene(scene);
        primaryStage.show();

        Double[][] data2 = new Double[2][10];
        for(int i = 0; i < 10; i++){
            data2[0][i] = (double) i;
            data2[1][i] =  (double) i * 3;
        }
        Object[][] data = {
                {"Intelligent (1)", "Nice (3)", "Good (1)", "Dumb (95)"},{1, 3, 1, 95}
        };
        try{
            GraphLib.createChart(GraphType.AREACHART, root, new ChartSpecs("Test", "XAxis", "YAxis", 500, 500, "chart1", "3x"), new GraphData<>(data2));
            GraphLib.createChart(GraphType.PIECHART, root, new ChartSpecs("Players in my Game (in %) ", 1000, 1000, "chart2"), new PieChartData(data));
        }
        catch(ArrayBoundsNotExpectedException e){
            e.printStackTrace();
        }
        scene.lookup("#chart2").setLayoutX(500);
        scene.lookup("#chart1").setStyle("");
    }
}
