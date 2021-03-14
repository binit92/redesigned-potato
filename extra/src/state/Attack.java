package state;

public class Attack extends MainPlay {

    public void next() {
        ge.setPhase(new Fortify(ge));
    }

    public void reinforce() {
        printInvalidCommandMessage();
    }

    public void attack() {
        System.out.println("attack done");
        ge.setPhase(new Fortify(ge));
    }

    public void fortify() {
        printInvalidCommandMessage();
    }
}
