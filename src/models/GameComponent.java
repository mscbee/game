package models;

public class GameComponent {

    private int id;

    private int instances;

    public GameComponent(int id, int instances) {
        this.id = id;
        this.instances = instances;
    }

    public GameComponent() {
    }

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
}
