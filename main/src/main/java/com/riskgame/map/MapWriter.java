package com.riskgame.map;


import java.io.File;

public class MapWriter  {

    private final String mapPath;

    public MapWriter(String path){
        this.mapPath = path;

    }

    private void createFile(String path) {
        try{

            if(!path.isEmpty()) {
                File mapFile = new File(path);

                if(!mapFile.exists()){
                    System.out.println("mapFile already exists, so loading the existing file ..");

                }else{
                    System.out.println("mapFile doesn;t exits, so creating a new one ..");
                    mapFile.createNewFile();

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    *  Algorithm:
    *  load com.riskgame.map from "editmap"
    *  create a com.riskgame.map in-memory with new continent
    *  on "savemap" command, update the original com.riskgame.map file
    * */
    public void addContinent(String continentID, String continentValue){
        //TODO
    }

    public void removeContinent(String continentID){
        //TODO
    }


    /*
     *  Algorithm:
     *  load com.riskgame.map from "editmap"
     *  create a com.riskgame.map in-memory with new continent
     *  on "savemap" command, update the original com.riskgame.map file
     * */
    public void addCountry(String countryID, String continentID){
        //TODO
    }

    public void removeCountry(String continentID){
        //TODO
    }

    /*
     *  Algorithm:
     *  load com.riskgame.map from "editmap"
     *  create a com.riskgame.map in-memory with new continent
     *  on "savemap" command, update the original com.riskgame.map file
     * */
    public void addNeighbor(String countryID, String neighborCountryID){
        //TODO
    }

    public void removeNeighbor(String countryID, String neighbourCountryID){
        //TODO
    }


    // Display com.riskgame.map as a text
    public void showMap(){
        //TODO: what is the algorithm here
    }

    public void saveMap(){
        //TODO : use "in-memory" com.riskgame.map to create a physical file
    }

    public void editMap(){
        //TODO : if file exists, load it to create "in-memory com.riskgame.map ", else create an empty "in-memory" com.riskgame.map
    }

    public void validateMap(){
        //TODO : what is the logic ?
    }

}
