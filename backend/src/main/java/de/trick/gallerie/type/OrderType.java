package de.trick.gallerie.type;

public enum OrderType {

    DEFAULT("id"),
    NEW("createdAt"),
    RATING("ratings");

    private String databaseName;


    private OrderType(String databaseName){
        this.databaseName = databaseName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

}
