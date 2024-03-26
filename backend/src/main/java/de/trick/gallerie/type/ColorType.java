package de.trick.gallerie.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ColorType {

    WHITE("Weiß", "#F6F6F6"),
    YELLOW("Gelb", "#ede215"),
    BLUE("Blau", "#3299c2"),
    RED("Rot", "#d72b0e"),
    GREEN("Grün", "#0fba8c"),
    BLACK("Schwarz", "#000000");

    private String name;

    private String color;


    private ColorType(String name, String color){
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getKey(){
        return this.toString();
    }

    @JsonCreator
    public static ColorType forValues(@JsonProperty("name") String name, @JsonProperty("key") String key, @JsonProperty("color") String color) {
        return ColorType.valueOf(key);
    }
}
