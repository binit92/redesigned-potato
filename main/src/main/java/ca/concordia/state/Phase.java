package ca.concordia.state;

import ca.concordia.controller.game.GameEngine;

//State in the State pattern
public abstract class Phase {
    GameEngine ge;

    // general behavior
    abstract public void loadMap();

    abstract public void showMap();

    // edit map state behavior
    abstract public void editCountry();

    abstract public void saveMap();

    // play state behavior
    // game setup state behavior
    abstract public void setPlayers();

    abstract public void assignCountries();

    // reinforcement state behavior
    abstract public void reinforce();

    // attack state behavior
    abstract public void attack();

    // fortify state behavior
    abstract public void fortify();

    // end state behavior
    abstract public void endGame();

    // go to next phase
    abstract public void next();

    // methods common to all states
    public void printInvalidCommandMessage() {
        System.out.println("Invalid command in state" + this.getClass().getSimpleName());
    }
}