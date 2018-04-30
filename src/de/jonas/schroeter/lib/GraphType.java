package de.jonas.schroeter.lib;

import java.util.Arrays;

/**
 * Created by Jonas Schroeter on 21.04.2018 for "GraphLib".
 */
public enum GraphType {

    BARCHART(),
    LINECHART(),
    SCATTEREDCHART(),
    BUBBLECHART(),
    PIECHART(),
    AREACHART();

    boolean isSpecial(){
        GraphType[] specials = {BUBBLECHART};
        return Arrays.asList(specials).contains(this);
    }

}
