package com.emeraldcube.ais.objects;

import com.emeraldcube.ais.objects.FormErrorWarning;

public class Form {

    private String title;
    private FormErrorWarning[] errors;
    private FormErrorWarning[] warnings;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setErrors(FormErrorWarning[] errors) {
        this.errors = errors;
    }

    public FormErrorWarning[] getErrors() {
        return errors;
    }

    public void setWarnings(FormErrorWarning[] warnings) {
        this.warnings = warnings;
    }

    public FormErrorWarning[] getWarnings() {
        return warnings;
    }
}