package ca.concordia;

import ca.concordia.gameengine.GameController;

/**
 * GameDriver
 */
public class Main {


    private GameController d_GameController;


    /**
     * Contructor of Main class
     */
    public Main() {
        d_GameController = new GameController();
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
    }
}