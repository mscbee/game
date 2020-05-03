package models;

import java.time.LocalTime;

public class GameComponent {

    private static int id = 0;
    private static int instances = 0;

    // Constructors
    public GameComponent(int id, int instances) {
        this.id = id;
        this.instances = instances;
    }

    public GameComponent() {
        id = instances++;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInstances() {
        return instances;
    }

    public void setInstances(int instances) {
        this.instances = instances;
    }

    // Member Functions
    public void update(LocalTime time){

    };
}
