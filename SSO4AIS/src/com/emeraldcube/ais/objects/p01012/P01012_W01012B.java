package com.emeraldcube.ais.objects.p01012;

import com.emeraldcube.ais.objects.Form;

public class P01012_W01012B extends Form {

    private P01012_W01012B_FormData data = new P01012_W01012B_FormData();

    public P01012_W01012B() {
        super();
    }

    public void setData(P01012_W01012B_FormData data) {
        this.data = data;
    }

    public P01012_W01012B_FormData getData() {
        return data;
    }
}
