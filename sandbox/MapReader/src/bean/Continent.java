package bean;

public class Continent {

    // TODO : why continents doesn't have unique-id like countries,
    // TODO : can I assume their id (starting from 1 ..) as the order goes in the .map file ?
    // final because continent name cannot be changed, but color and army-count can change
    private final String name;
    private String color;
    private int armyCount;

    public Continent(String name) {
        this.name = name;
    }

    public Continent(String name,int armyCount, String color){
        this.name = name;
        this.armyCount = armyCount;
        this.color = color;
    }

    /** Getters and Setters **/
    public String getName(){
        return  name;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public void setArmyCount(int armyCount){
        this.armyCount = armyCount;
    }

    public int getArmyCount(){
        return armyCount;
    }
}
