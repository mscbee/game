package models;

import java.time.LocalTime;
import java.util.*;

public class DrawableGameComponent extends GameComponent{
    public Direction direction;

    private int x;

    private int y;

    public static final int SCREEN_HEIGHT = 20;

    public static final int SCREEN_WIDTH = 80;


    // Getters and Setters
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Constructors
    public DrawableGameComponent() {
        direction = Direction.RIGHT;
        x = 0;
        y = 0;
    }

    // Member Methods
    public void update(LocalTime time) {
        TimerTask task = new TimerTask(){
            public void run() {
                DrawableGameComponent drawableGameComponent = new DrawableGameComponent();

                System.out.println("ID: " + drawableGameComponent.getId() + " Updated @ " + time);

                int x = drawableGameComponent.getX();

                if(drawableGameComponent.getDirection() == Direction.LEFT) {
                    drawableGameComponent.setX(x--);
                }
                else if(drawableGameComponent.getDirection() == Direction.RIGHT) {
                    drawableGameComponent.setX(x++);
                }

                int y = drawableGameComponent.getY();

                if(drawableGameComponent.getDirection() == Direction.UP) {
                    drawableGameComponent.setY(y++);
                }
                else if(drawableGameComponent.getDirection() == Direction.DOWN) {
                    drawableGameComponent.setY(y--);
                }

                drawableGameComponent.draw();
                drawableGameComponent.changeDirection();
            }
        };

        Timer timer = new Timer("Timer");

        Date now = new Date();

//        for(int i= 0; i<5; i++) {
            long delay = 1000L;
            timer.schedule(task, now, delay);
//        }
    }

    private void draw() {
        DrawableGameComponent drawableGameComponent = new DrawableGameComponent();

        Direction direction = drawableGameComponent.getDirection();
        int x = drawableGameComponent.getX();
        int y = drawableGameComponent.getY();

        String drawableGameComponentDirection = direction.toString();

        switch(direction) {
            case LEFT:
                drawableGameComponentDirection = "Left";
                break;
            case RIGHT:
                drawableGameComponentDirection = "Right";
                break;
            case UP:
                drawableGameComponentDirection = "Up";
                break;
            case DOWN:
                drawableGameComponentDirection = "Down";
        }

        System.out.println(drawableGameComponentDirection + " : " + "X:" + x + "  " + "Y:" + y);
    }

    private void changeDirection() {
        //TODO: Fix this method - right now it isn't changing direction randomly as expected
        DrawableGameComponent drawableGameComponent = new DrawableGameComponent();
        List<Direction> directions = new ArrayList<>();
        directions.add(Direction.DOWN);
        directions.add(Direction.UP);
        directions.add(Direction.RIGHT);
        directions.add(Direction.LEFT);

        Random random = new Random();

        int numberOfElements = 4;

        for(int i=0; i<numberOfElements; i++) {
            int randomIndex = random.nextInt(directions.size());
            Direction randomElement = directions.get(randomIndex);

            drawableGameComponent.setDirection(randomElement);
            directions.remove(randomIndex);
        }
    }
}
