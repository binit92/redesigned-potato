package ca.concordia.patterns.state.play;

import ca.concordia.gameengine.GameEngine;
import ca.concordia.patterns.state.Phase;

public class Play extends Phase {

    public Play(GameEngine p_ge){
        super(p_ge);
    }

    @Override
    public void loadMap(String[] p_Command) {

    }

    @Override
    public void showMap(){
        System.out.println("map is being displayed");
    }

    @Override
    public void editContinent(String[] p_Command) {

    }

    @Override
    public void editCountry(String[] p_Command){
        printInvalidCommandMessage();
    }

    @Override
    public void editNeighbour(String[] p_Command) {

    }

    @Override
    public void saveMap(String[] p_Command) {

    }

    @Override
    public void editMap(String[] p_Command) {

    }

    @Override
    public void validateMap(String[] p_Command) {

    }

    @Override
    public void setPlayers(String[] p_Command) {

    }

    @Override
    public void assignCountries() {

    }

    @Override
    public void reinforce() {

    }

    @Override
    public void attack() {

    }

    @Override
    public void fortify() {

    }

    @Override
    public void endGame(){
        // TODO
        //ge.setPhase(new End(ge));
    }

    @Override
    public void next() {

    }
}
