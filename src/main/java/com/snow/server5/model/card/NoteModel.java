package com.snow.server5.model.card;

import com.snow.server5.model.ModelCarrier;

public class NoteModel implements ModelCarrier {
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
