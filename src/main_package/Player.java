package main_package;

public class Player {
    public final int id;
    public int points;
    public boolean isActive;
    private final String name;
    private final String color;

        public Player(int id, int points, boolean isActive, String name, String color){
        this.id = id;
        this.points = points;
        this.isActive = isActive;
        this.name = name;
        this.color = color;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getId() {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getColor() {
        return color;
    }
}
