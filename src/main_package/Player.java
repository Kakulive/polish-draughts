package main_package;

public class Player {
    public int id;
    public int points;
    private final String name;

    public Player(int id, int points, String name){
        this.id = id;
        this.points = points;
        this.name = name;
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
