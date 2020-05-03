import models.DrawableGameComponent;
import models.Game;
import models.GameComponent;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Game game = new Game();

        GameComponent gameComponent = new GameComponent();

        List<GameComponent> gameComponents = new ArrayList<>();
        gameComponents.add(gameComponent);

        game.addGameComponent(gameComponents);

        DrawableGameComponent drawableGameComponent = new DrawableGameComponent();
        List<DrawableGameComponent> drawableGameComponents = new ArrayList<>();
        drawableGameComponents.add(drawableGameComponent);

        game.addDrawableGameComponent(drawableGameComponents);

        game.run();
    }
}
