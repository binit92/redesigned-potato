package ca.concordia.patterns.state.play;

import ca.concordia.gameengine.GameEngine;

public class Attack extends MainPlay {

    public Attack(GameEngine p_ge) {
        super(p_ge);
    }

    public void next() {
        //TODO
        //ge.setPhase(new Fortify(ge));
    }

    public void reinforce() {
        printInvalidCommandMessage();
    }

    public void attack() {
        System.out.println("attack done");
        //TODO
        //ge.setPhase(new Fortify(ge));
    }

    public void fortify() {
        printInvalidCommandMessage();
    }
}
