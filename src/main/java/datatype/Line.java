package main.java.datatype;

import javafx.scene.paint.Paint;

public class Line {

    private final String name;
    private final Paint color;

    public Line(String name, Paint color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Paint getColor() {
        return color;
    }

}