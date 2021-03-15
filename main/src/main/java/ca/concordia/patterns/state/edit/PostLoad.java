package ca.concordia.patterns.state.edit;

public class PostLoad extends Edit {


    public void loadMap() {
        System.out.println("map has been loaded");
    }

    public void editCountry() {
        System.out.println("country has been edited");
    }

    public void saveMap() {
        System.out.println("map has been  saved");
        //TODO
        //ge.setPhase(new PlaySetup(ge));
    }

    public void next() {
        System.out.println("must save map");
    }

}
