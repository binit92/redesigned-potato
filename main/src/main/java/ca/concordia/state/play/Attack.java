package ca.concordia.state.play;

import ca.concordia.state.play.MainPlay;

public class Attack extends MainPlay {

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
