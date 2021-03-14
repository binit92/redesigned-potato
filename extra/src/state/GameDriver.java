package state;

// Client in the State pattern
public class GameDriver {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.start();

    }
}