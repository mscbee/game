package models;

import java.time.LocalTime;
import java.util.*;

public class Game {
    private int componentCount;

    private List<GameComponent> components;

    private FP fp;

    // Constructors
    public Game() {

    }

    // Getters and Setters
    public int getComponentCount() {
        return componentCount;
    }

    public void setComponentCount(int componentCount) {
        this.componentCount = componentCount;
    }

    public List<GameComponent> getComponents() {
        return components;
    }

    public void setComponents(List<GameComponent> components) {
        this.components = components;
    }

    public FP getFp() {
        return fp;
    }

    public void setFp(FP fp) {
        this.fp = fp;
    }

    // Member Functions
    private List<GameComponent> gameComponents = new ArrayList<>();

    private List<DrawableGameComponent> dGComponents = new ArrayList<>();

    private LocalTime time;

    private FP init = FP.INITIALISE;

    private FP term = FP.TERMINATE;


    public void addGameComponent(List<GameComponent> components) {
        for(GameComponent component: components) {
            gameComponents.add(component);
        }
    }

    public void addDrawableGameComponent(List<DrawableGameComponent> drawableGameComponents) {
        for(DrawableGameComponent component: drawableGameComponents) {
            dGComponents.add(component);
        }
    }

    public void run() {
        setInitialize(init);

            LocalTime timeOfInvocation = LocalTime.now();
            time = timeOfInvocation;

            for(GameComponent gameComponent: gameComponents) {
                gameComponent.update(time);
            }

            for(DrawableGameComponent drawableGameComponent: dGComponents) {
                drawableGameComponent.update(time);
            };

        setTerminate(term);
    }

    public void setInitialize(FP init) {
        try {
            if(init == FP.INITIALISE) {
                System.out.println("Initialising game");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTerminate(FP term) {
        try {
            if(term == FP.TERMINATE) {
                System.out.println("Terminating game");
                gameComponents.removeAll(gameComponents);
                dGComponents.removeAll(dGComponents);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
