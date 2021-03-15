package ca.concordia;

import ca.concordia.gameengine.GameController;
import ca.concordia.dao.GameModel;
import ca.concordia.patterns.observer.GameView;

/**
 * Starting point of the class that initializes all three model, view and controller
 */
public class Main {

    private GameModel d_GameModel;
    private GameController d_GameController;
    private GameView d_GameView;

    /**
     * Contructor of Main class
     */
    public Main() {
        d_GameModel = new GameModel();
        d_GameView = new GameView(d_GameModel);
        d_GameController = new GameController(d_GameView, d_GameModel);
    }

    /**
     * main method to start the exeuction
     *
     * @param args arguments to the program, the game is not expecting any argument on startup
     */
    public static void main(String[] args) {
        System.out.println("Welcome to TEAM-11 Game");
        new Main().startGame();
    }

    /**
     * StartGame function to start the execution using controller by taking command inputs from users.
     */
    public void startGame() {
        d_GameController.takeCommandInput();
        d_GameModel.detach(d_GameView);
    }
}