package de.trick.gallerie.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PicturesizeType {

    S10X10("10x10"),
    S15X10("15x10"),
    S15X15("15x15"),
    S18X24("18x24"),
    S20X20("20x20"),
    S24X30("24x30"),
    S30X30("30x30"),
    S40X40("40x40"),
    S50X60("50x60"),
    S50X70("50x70"),
    S60X60("60x60"),
    S60X80("60x80"),
    S70X100("70x100"),
    S75X120("75x120"),
    S80X80("80x80"),
    S80X100("80 x 120"),
    S80X120("80x120"),
    S120X140("120x140");

    private String name;

    private PicturesizeType(String name, String key){
        this.name = name;
    }

    private PicturesizeType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getKey(){
        return this.toString();
    }

    @JsonCreator
    public static PicturesizeType forValues(@JsonProperty("name") String name, @JsonProperty("key") String key) {
        return PicturesizeType.valueOf(key);
    }
}
