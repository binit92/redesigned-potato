package state;

// State of the state pattern
public abstract class MainPlay extends Play{

    public void loadMap() {
        this.printInvalidCommandMessage();
    }

    public void setPlayers() {
        this.printInvalidCommandMessage(); }

        public void assignCountries() {
        this.printInvalidCommandMessage();
    }
}
