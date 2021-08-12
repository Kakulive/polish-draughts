package main_package;

public class Pawn {
    private int coordinateX;
    private int coordinateY;
    private final String color;

    public Pawn(int coordinateX, int coordinateY, String color) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.color = color;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public String getColor() {
        return color;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
}
