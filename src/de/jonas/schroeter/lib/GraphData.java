package de.jonas.schroeter.lib;

/**
 * Created by Jonas Schroeter on 21.04.2018 for "GraphLib".
 */
public class GraphData<T>{
    
    private T[] dataX;
    private T[] dataY;

    public GraphData(T[][] data) throws ArrayBoundsNotExpectedException {
        if(data.length != 2 || data[0].length != data[1].length)throw new ArrayBoundsNotExpectedException("Data array got wrong bounds!");
        dataX = data[0];
        dataY = data[1];
    }
    T[] getDataX() {
        return dataX;
    }

    T[] getDataY() {
        return dataY;
    }
    T getXDataAt(int index){
        return dataX[index];
    }
    T getYDataAt(int index){
        return dataY[index];
    }
    Class<?> getType(){
        return dataX[0].getClass();
    }
}
