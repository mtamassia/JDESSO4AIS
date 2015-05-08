package com.emeraldcube.ais.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FormErrorWarning {
    
    String CODE;
    String TITLE;    
    String DESC;    
    String MOBILE;    
    String ERRORCONTROL;
    
    public FormErrorWarning() {
        super();
    }

    @JsonProperty("DESC")
    public void setDESC(String DESC) {
        this.DESC = DESC;
    }

    public String getDESC() {
        return DESC;
    }

    @JsonProperty("CODE")
    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getCODE() {
        return CODE;
    }

    @JsonProperty("TITLE")
    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getTITLE() {
        return TITLE;
    }

    @JsonProperty("MOBILE")
    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE;
    }

    public String getMOBILE() {
        return MOBILE;
    }
    
    @JsonProperty("ERRORCONTROL")
    public void setERRORCONTROL(String ERRORCONTROL) {
		this.ERRORCONTROL = ERRORCONTROL;
    }
	
    public String getERRORCONTROL() {
	return ERRORCONTROL;
    }
}
