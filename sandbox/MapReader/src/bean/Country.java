package bean;

/**
 *  Details of maps can be found at : http://domination.sourceforge.net/makemaps.shtml
 */

public class Country {

    // name will not change
    private final String d_NAME; // unique name of the country
    private final int d_NUMBER;  // unique id of country starting from 1
    private int d_PARENT;        // content id it belongs to .. TODO: check this
    private int d_X;             // x co-ordinate
    private int d_Y;             // y co-ordinate
    private int d_ARMIES;        //Country owned armies
    private Player d_PL;        //Owner of the country
    private Continent d_CONTINENT;  //Continent of the country
    

    public Country(String name, int number) {
        this.d_NAME = name;
        this.d_NUMBER = number;
    }

    public Country (String p_name, int p_number , int p_parent, int p_a, int p_b, Continent p_c,int p_col){
        this.d_NAME = p_name;
        this.d_NUMBER = p_number;
        this.d_PARENT = p_parent;
        this.d_X = p_a;
        this.d_Y = p_b;
       this.d_CONTINENT	= p_c;
        d_PL		=null;
        d_ARMIES	=0;
       
    }

    /** Getters and Setters **/
    public String getName(){
        return d_NAME;
    }

    public int getNumber(){
        return d_NUMBER;
    }

    public void setParent(int p_parent){
        this.d_PARENT = p_parent;
    }

    public int getParent(){
        return d_PARENT;
    }

    public void setX(int p_x){
        this.d_X = p_x;
    }

    public int getX(){
        return d_X;
    }

    public void setY(int p_y){
        this.d_Y = p_y;
    }

    public int getY(){
        return d_Y;
    }
    /**
     * Add armies using a parameter
     * @param p_arm the number of armies
     */
    public void addArmies(int p_arm) {
        d_ARMIES = d_ARMIES + p_arm;
    }

    public int getArmies() {
        return d_ARMIES;
    }
    /**
     * defeated armies are removed from a country
     * @param p_defarm
     */
    public void removeArmies(int p_defarm) {
        d_ARMIES = d_ARMIES - p_defarm;
    }

    public void setOwner(Player p_p) {
        d_PL= p_p;
    }


    public Player getOwner() {
        return d_PL;
    }

    public void setContinent(Continent p_a) {
        d_CONTINENT = p_a;
    }

    /**
     * Returns the Continent of the country
     * @return continent
     */

    public Continent getContinent() {
        return d_CONTINENT;
    }


}
