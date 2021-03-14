package state;

public class Preload extends Edit {


    public void loadMap() {
        System.out.println("map has been loaded");
        ge.setPhase(new PostLoad(ge));
    }

    public void editCountry() {
        printInvalidCommandMessage();
    }

    public void saveMap() {
        printInvalidCommandMessage();
    }

    public void next() {
        System.out.println("must load map");
    }

}
