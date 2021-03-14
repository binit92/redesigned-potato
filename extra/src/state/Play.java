package state;

public class Play extends Phase {

    @Override
    public void loadMap() {

    }

    @Override
    public void showMap(){
        System.out.println("map is being displayed");
    }

    @Override
    public void editCountry(){
        printInvalidCommandMessage();
    }

    @Override
    public void saveMap() {

    }

    @Override
    public void setPlayers() {

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
        ge.setPhase(new End(ge));
    }

    @Override
    public void next() {

    }
}
