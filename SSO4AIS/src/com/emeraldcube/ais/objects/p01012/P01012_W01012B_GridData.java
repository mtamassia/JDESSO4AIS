package com.emeraldcube.ais.objects.p01012;

import com.emeraldcube.ais.objects.GridData;
import java.util.ArrayList;

public class P01012_W01012B_GridData extends GridData {

    private P01012_W01012B_GridColumnTitles titles = new P01012_W01012B_GridColumnTitles();

    private ArrayList<P01012_W01012B_GridRow> rowset = new ArrayList<P01012_W01012B_GridRow>();

    public P01012_W01012B_GridData() {
        super();
    }

    public void setTitles(P01012_W01012B_GridColumnTitles titles) {
        this.titles = titles;
    }

    public P01012_W01012B_GridColumnTitles getTitles() {
        return titles;
    }

    public void setRowset(ArrayList<P01012_W01012B_GridRow> rowset) {
        this.rowset = rowset;
    }

    public ArrayList<P01012_W01012B_GridRow> getRowset() {
        return rowset;
    }
}
