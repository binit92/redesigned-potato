package ca.concordia.patterns.state.edit;

import ca.concordia.gameengine.GameEngine;
import ca.concordia.mapworks.MapEditor;

import java.io.File;
import java.io.IOException;

public class PostLoad extends Edit {


    public PostLoad(GameEngine p_ge) {
        super(p_ge);
    }

    @Override
    public void editContinent(String[] p_Command) {
        System.out.println("editcontinent command received ..... ");
        for (int l_I = 0; l_I < p_Command.length; l_I++) {
            String l_Tag = p_Command[l_I];

            if (l_Tag.toLowerCase().startsWith("-add")) {
                if (l_I + 2 < p_Command.length) {
                    String l_ContinentName = p_Command[++l_I];
                    String l_ContinentArmyCount = p_Command[++l_I];
                    int l_ContinentArmyCountInteger = Integer.parseInt(l_ContinentArmyCount);
                    if (MapEditor.getInstance().addContinent(l_ContinentName, l_ContinentArmyCountInteger)) {
                        System.out.println("Successfully added continent name: " + l_ContinentName + " army: " + l_ContinentArmyCount + " into the map");
                    }

                } else {
                    System.out.println("INCOMPLETE COMMAND ");
                }

            } else if (l_Tag.toLowerCase().startsWith("-remove")) {
                if (l_I + 1 < p_Command.length) {
                    String l_ContinentName = p_Command[++l_I];
                    if (MapEditor.getInstance().removeContinent(l_ContinentName)) {
                        System.out.println("Successfully removed continent name: " + l_ContinentName + " from the map");
                    }
                } else {
                    System.out.println("INCOMPLETE COMMAND");
                }
            }
        }

    }

    @Override
    public void editCountry(String[] p_Command) {
        System.out.println("editcountry command received ..... ");
        for (int l_I = 0; l_I < p_Command.length; l_I++) {
            String l_Tag = p_Command[l_I];
            if (l_Tag.toLowerCase().startsWith("-add")) {
                if (l_I + 2 < p_Command.length) {
                    String l_CountryName = p_Command[++l_I];
                    String l_ContinentName = p_Command[++l_I];
                    if (MapEditor.getInstance().addCountry(l_CountryName, l_ContinentName)) {
                        System.out.println("Successfully added country name: " + l_CountryName + " to continent name:  " + l_ContinentName + " into the map");
                    }

                } else {
                    System.out.println("INCOMPLETE COMMAND ");
                }

            } else if (l_Tag.toLowerCase().startsWith("-remove")) {
                if (l_I + 1 < p_Command.length) {
                    String l_CountryName = p_Command[++l_I];
                    if (MapEditor.getInstance().removeCountryUsingName(l_CountryName)) {
                        System.out.println("Successfully removed country name: " + l_CountryName + " from the map");
                    }
                } else {
                    System.out.println("INCOMPLETE COMMAND");
                }
            }
        }
    }

    @Override
    public void editNeighbour(String[] p_Command) {
        System.out.println("editneighbor command received ..... ");
        for (int l_I = 0; l_I < p_Command.length; l_I++) {
            String p_Tag = p_Command[l_I];
            if (p_Tag.toLowerCase().startsWith("-add")) {
                if (l_I + 2 < p_Command.length) {
                    String l_CountryName = p_Command[++l_I];
                    String l_NeighbourCountryName = p_Command[++l_I];
                    if (MapEditor.getInstance().addNeighbor(l_CountryName, l_NeighbourCountryName)) {
                        System.out.println("Successfully added neighbour name " + l_CountryName + " to " + l_NeighbourCountryName + " into the map");
                    }

                } else {
                    System.out.println("INCOMPLETE COMMAND ");
                }

            } else if (p_Tag.toLowerCase().startsWith("-remove")) {
                if (l_I + 2 < p_Command.length) {
                    String l_CountryName = p_Command[++l_I];
                    String l_NeighbourCountryName = p_Command[++l_I];
                    if (MapEditor.getInstance().removeNeighbor(l_CountryName, l_NeighbourCountryName)) {
                        System.out.println("Successfully removed neighbour name " + l_CountryName + " to " + l_NeighbourCountryName + " into the map");
                    }
                } else {
                    System.out.println("INCOMPLETE COMMAND");
                }
            }
        }

    }

    @Override
    public void saveMap(String[] p_Command) {
        try {
            if (p_Command.length == 2) {
                System.out.println("savemap command received ..");
                String l_Filename = p_Command[1];
                File l_MapPath = new File(l_Filename);
                MapEditor.getInstance().saveMap(l_MapPath);
            } else {
                System.out.println("INCOMPLETE COMMAND");
            }
        } catch (IOException p_Io) {
            p_Io.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException p_A) {
            p_A.printStackTrace();
        }
    }

    @Override
    public void editMap(String[] p_Command) {
        try {
            if (p_Command.length == 2) {
                String l_Filename = p_Command[1];
                if (!l_Filename.isEmpty()) {
                    System.out.println("editmap command received ..");
                    File l_MapFile = new File(l_Filename);
                    MapEditor.getInstance().editMap(l_MapFile);
                }
            } else {
                System.out.println("INCOMPLETE COMMAND, create an in-memory map file from scratch");
                MapEditor.getInstance().editMap(null);
            }
        } catch (IOException p_Io) {
            p_Io.printStackTrace();
        }
    }

    @Override
    public void validateMap(String[] p_Command) {
        System.out.println("validatemap command received ...");
        MapEditor.getInstance().validateMap();
    }

    @Override
    public void loadMap(String[] p_Command) {

    }

    @Override
    public void setPlayers(String[] p_Command) {

    }

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
