package state;

// Context of the State pattern.
public class GameEngine {
    private Phase gamePhase;

    public void setPhase(Phase p_phase) {
        gamePhase = p_phase;
    }

    public void start() {
        //…
        // Can change the state of the Context (GameEngine) object, e.g.
        setPhase(new Preload(this));
        setPhase(new PlaySetup(this));
        //…
        // Can trigger State  dependent behavior by using
        // the methods defined in the State (Phase) object, e.g.
        gamePhase.loadMap();
        gamePhase.reinforce();
        gamePhase.next();
    }
    //…
}