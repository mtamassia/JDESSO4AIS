package com.emeraldcube.ais.objects.p01012;

import com.emeraldcube.ais.objects.Field;
import com.emeraldcube.ais.objects.Field;
import com.emeraldcube.ais.objects.GridRow;

import java.util.Date;

public class P01012_W01012B_GridRow extends GridRow {

    Field mnAddressNumber_19 = new Field();
    Field sAlphaName_20 = new Field();
    Field sLongAddress_48 = new Field();
    Field sIndustryClass_49 = new Field();
    Field sSchTyp_50 = new Field();
    Field sTaxID_51 = new Field();

    public P01012_W01012B_GridRow() {
        super();
    }

    public void setMnAddressNumber_19(Field mnAddressNumber_19) {
        this.mnAddressNumber_19 = mnAddressNumber_19;
    }

    public Field getMnAddressNumber_19() {
        return mnAddressNumber_19;
    }

    public void setsAlphaName_20(Field sAlphaName_20) {
        this.sAlphaName_20 = sAlphaName_20;
    }

    public Field getSAlphaName_20() {
        return sAlphaName_20;
    }

    public void setsLongAddress_48(Field sLongAddress_48) {
        this.sLongAddress_48 = sLongAddress_48;
    }

    public Field getSLongAddress_48() {
        return sLongAddress_48;
    }

    public void setsIndustryClass_49(Field sIndustryClass_49) {
        this.sIndustryClass_49 = sIndustryClass_49;
    }

    public Field getSIndustryClass_49() {
        return sIndustryClass_49;
    }

    public void setsSchTyp_50(Field sSchTyp_50) {
        this.sSchTyp_50 = sSchTyp_50;
    }

    public Field getSSchTyp_50() {
        return sSchTyp_50;
    }

    public void setsTaxID_51(Field sTaxID_51) {
        this.sTaxID_51 = sTaxID_51;
    }

    public Field getSTaxID_51() {
        return sTaxID_51;
    }
}
