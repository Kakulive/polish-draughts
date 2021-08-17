package main_package;

public class Player {
    public final int id;
    public int points;
    public boolean isActive;
    private final String name;

    public Player(int id, int points, boolean isActive, String name){
        this.id = id;
        this.points = points;
        this.isActive = isActive;
        this.name = name;
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
}
