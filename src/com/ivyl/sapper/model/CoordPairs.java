package com.ivyl.sapper.model;

import java.util.ArrayList;

public class CoordPairs {
    private int coordI;
    private int coordJ;
    private ArrayList<CoordPairs> coordPairsList;

    public CoordPairs() {
        coordPairsList = new ArrayList<CoordPairs>();
    }

    public int getCoordI() {
        return coordI;
    }

    public int getCoordJ() {
        return coordJ;
    }

    public ArrayList<CoordPairs> getCoordPairsList() {
        return coordPairsList;
    }

    public void setCoordI(int coordI) {
        this.coordI = coordI;
    }

    public void setCoordJ(int coordJ) {
        this.coordJ = coordJ;
    }
}
