package ca.concordia.patterns.state.play;

import ca.concordia.dao.Country;
import ca.concordia.dao.Map;
import ca.concordia.dao.Player;
import ca.concordia.gameengine.GameEngine;
import ca.concordia.mapworks.MapEditor;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class PlaySetup extends Play {

    public PlaySetup(GameEngine p_ge, Map p_map) {
        //super(p_ge,p_map);
        super(p_ge);
        super.d_map = p_map;
    }

    /**
     * game starts with loading of user-saved map file, which loads the map
     * as a "connected-directed-graph"
     */
    @Override
    public void loadMap(String[] p_Command) {
        System.out.println("load map to start game ..");
        try {
            String l_Filename = p_Command[1];
            if (!l_Filename.isEmpty()) {
                System.out.println("loadmap command received ..");
                File l_MapFile = new File(l_Filename);
                if (l_MapFile.exists()) {
                    Map l_Map = MapEditor.getInstance().readMapFile(l_MapFile);

                    // TODO : updating map in the parent .. (review this)
                    super.d_map = l_Map;
                    System.out.println(" map is successfully loaded and ready for gameplay ..");

                } else {
                    System.out.println("The map file" + l_MapFile.getAbsolutePath() + "doesn't exists");
                }
            }
        } catch (Exception p_E) {
            p_E.printStackTrace();
        }
    }

    @Override
    public void setPlayers(String[] p_Command) {
        System.out.println("gameplayer command received ..... ");

        for (int l_I = 0; l_I < p_Command.length; l_I++) {
            String l_Tag = p_Command[l_I];

            if (l_Tag.toLowerCase().startsWith("-add")) {
                if (l_I + 1 < p_Command.length) {
                    String l_PlayerName = p_Command[++l_I];
                    addPlayer(l_PlayerName);
                } else {
                    System.out.println("INCOMPLETE COMMAND ");
                }

            } else if (l_Tag.toLowerCase().startsWith("-remove")) {
                if (l_I + 1 < p_Command.length) {
                    String l_PlayerName = p_Command[++l_I];
                    removePlayer(l_PlayerName);
                } else {
                    System.out.println("INCOMPLETE COMMAND");
                }
            }
        }
    }


    /**
     * takes player name and if there is no player with such name, it adds a new player with this name
     * in playerlist
     *
     * @param p_PlayerName playername to add
     * @return boolean
     */
    private boolean addPlayer(String p_PlayerName) {
        int l_Count = 0;
        for (Player l_Player : d_ListOfPlayers) {
            l_Count++;
            if (l_Player.getPlayerName().equalsIgnoreCase(p_PlayerName)) {
                System.out.println("A player with name: " + p_PlayerName + " already exists!");
                return false;
            }
        }
        Player l_NewPlayer = new Player(p_PlayerName, l_Count);
        return d_ListOfPlayers.add(l_NewPlayer);
    }

    /**
     * takes playerName and if it is found in existing playerlist, remove it .
     *
     * @param p_PlayerName playername to remove
     * @return boolean
     */
    private boolean removePlayer(String p_PlayerName) {
        for (Player l_Player : d_ListOfPlayers) {
            if (l_Player.getPlayerName().equalsIgnoreCase(p_PlayerName)) {
                return d_ListOfPlayers.remove(l_Player);
            }
        }
        System.out.println("player not found : " + p_PlayerName);
        return false;
    }


    @Override
    public void assignCountries() {

        System.out.println("assigncountries command received..");
        try {
            int l_NumberOfPlayers = d_ListOfPlayers.size();
            if (l_NumberOfPlayers >= 3 && l_NumberOfPlayers <= 5) {
                System.out.println("number of countries between [3 to 5] so assign countries to player now ..");
                assignCountriesToPlayers();
            } else {
                System.out.println("number of player must be between [3 to 5] to state main-game-loop");
            }

        } catch (Exception l_E) {
            l_E.printStackTrace();
        }

        // start main-loop after this..
        d_ge.setPhase(new Reinforcement(d_ge));

    }


    /**
     * This method assigns countries to players
     *
     * @return boolean
     */
    private boolean assignCountriesToPlayers() {
        if (d_ListOfPlayers.size() < MINIMUM_PLAYER_COUNT) {
            System.out.println("Number of players should be atleast " + MINIMUM_PLAYER_COUNT + " to start assigning countries");
            return false;
        }
        if (d_map.getListOfCountries().size() == 0) {
            System.out.println("Zero countries in the map, so unable to assign anything to players");
            return false;
        }
        System.out.println("Number of countries available is : " + d_map.getListOfCountries().size());

        System.out.println("start assigning countries ");

        int l_CountryCount = d_map.getListOfCountries().size();
        int l_PlayerCount = this.d_ListOfPlayers.size();
        int l_PlayerCountryRatio = l_CountryCount / l_PlayerCount;
        System.out.println("player-country ratio: " + l_PlayerCountryRatio);
        ArrayList<Country> l_CountriesToAssignRandomly = new ArrayList<Country>();
        for (Country l_Country : d_map.getListOfCountries()) {
            l_CountriesToAssignRandomly.add(l_Country);
        }

        while (l_CountriesToAssignRandomly.size() > 0) {
            for (Player l_Player : d_ListOfPlayers) {
                if (l_CountriesToAssignRandomly.size() == 0) {
                    System.out.println("All countries has been assigned ");
                    break;
                } else if (l_CountriesToAssignRandomly.size() == 1) {
                    Country l_Country = l_CountriesToAssignRandomly.get(0);
                    l_CountriesToAssignRandomly.remove(l_Country);
                    l_Player.addNewCountry(l_Country);
                    System.out.println(l_Player.getPlayerName() + " has " + l_Country.getName());
                } else {
                    int l_Index = new Random().nextInt(l_CountriesToAssignRandomly.size() - 1);
                    Country l_Country = l_CountriesToAssignRandomly.get(l_Index);
                    l_CountriesToAssignRandomly.remove(l_Country);
                    l_Player.addNewCountry(l_Country);
                    System.out.println(l_Player.getPlayerName() + " has " + l_Country.getName());
                }

            }
        }
        return true;
    }

}
