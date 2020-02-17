package com.snow.server5.model.card;

import com.snow.server5.model.ModelCarrier;

public class ReferenceModel implements ModelCarrier {
    private String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
