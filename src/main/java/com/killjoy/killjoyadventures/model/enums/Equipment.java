package com.killjoy.killjoyadventures.model.enums;

public enum Equipment {
    MINIGOLF_KOELLER("Golfkøller"),
    SUMO_DRAGT("Sumodragt"),
    PAINTBALL_PISTOLER("Paintball skyder");

    public final String label;



    private Equipment (String label) {
        this.label = label;
}
    public String getLabel() {
        return label;
    }
}

