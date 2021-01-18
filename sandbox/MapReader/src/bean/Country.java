package bean;

/**
 *  Details of maps can be found at : http://domination.sourceforge.net/makemaps.shtml
 */

public class Country {

    // name will not change
    private final String name; // unique name of the country
    private final int number;  // unique id of country starting from 1
    private int parent;        // content id it belongs to .. TODO: check this
    private int x;             // x co-ordinate
    private int y;             // y co-ordinate



    public Country(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Country (String name, int number , int parent, int x, int y){
        this.name = name;
        this.number = number;
        this.parent = parent;
        this.x = x;
        this.y = y;
    }

    /** Getters and Setters **/
    public String getName(){
        return name;
    }

    public int getNumber(){
        return number;
    }

    public void setParent(int parent){
        this.parent = parent;
    }

    public int getParent(){
        return parent;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getX(){
        return x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getY(){
        return y;
    }

}
