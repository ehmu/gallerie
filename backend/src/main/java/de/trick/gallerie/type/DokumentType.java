package de.trick.gallerie.type;

public enum DokumentType {

    IMAGE("Image"),
    PDF("PDF"),
    SONSTIGE("Sonstige");

    private String displayName;


    private DokumentType(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
