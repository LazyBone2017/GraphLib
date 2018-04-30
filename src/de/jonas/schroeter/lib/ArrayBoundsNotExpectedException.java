package de.jonas.schroeter.lib;

/**
 * Created by Jonas Schroeter on 21.04.2018 for "GraphLib".
 */

public class ArrayBoundsNotExpectedException extends Exception{

    ArrayBoundsNotExpectedException(){
        super();
    }
    ArrayBoundsNotExpectedException(String message){
        super(message);
    }
}
