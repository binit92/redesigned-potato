package ca.concordia.gameengine;

import ca.concordia.Main;
import ca.concordia.dao.*;
import ca.concordia.mapworks.MapEditor;
import ca.concordia.patterns.state.Phase;
import ca.concordia.patterns.state.edit.Preload;
import ca.concordia.patterns.state.play.PlaySetup;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Game Engine class that starts with "loadmap" command and automatically ends after mainloop phases
 */
public class GameEngine {

    // Map editor commands
    public static final String COMMAND_EDIT_CONTINENT = "editcontinent";
    public static final String COMMAND_EDIT_COUNTRY = "editcountry";
    public static final String COMMAND_EDIT_NEIGHBOUR = "editneighbor";
    public static final String COMMAND_SAVE_MAP = "savemap";
    public static final String COMMAND_EDIT_MAP = "editmap";
    public static final String COMMAND_VALIDATE_MAP = "validatemap";

    //Any commands
    public static final String COMMAND_SHOW_MAP = "showmap";
    public static final String COMMAND_QUIT = "quit";

    // play commands
    public static final String COMMAND_LOAD_MAP = "loadmap";
    public static final String COMMAND_GAME_PLAYER = "gameplayer";
    public static final String COMMAND_ASSIGN_COUNTRIES = "assigncountries";
    public static final String COMMAND_DEPLOY = "deploy";
    public static final String COMMAND_ADVANCE = "advance";
    public static final String COMMAND_BOMB = "bomb";
    public static final String COMMAND_BLOCKADE = "blockade";
    public static final String COMMAND_AIRLIFT = "airlift";
    public static final String COMMAND_NEGOTIATE = "negotiate";

    // data members

    public static boolean GAME_STARTED = false;
    private static GameEngine d_Instance = null;
    private  Map d_CurrentMap;
    private  PlayerActions d_PlayerActions;
    private Graph d_Graph;

    private Phase d_GamePhase;

    public void setPhase(Phase p_Phase){
        this.d_GamePhase = p_Phase;
    }

    public void start(){

        Scanner keyboard = new Scanner(System.in);
        do{
            System.out.println("========================================");
            System.out.println("edit");
            System.out.println("play");
            System.out.println("quit");
            System.out.println("choose one of the option from above?: ");
            System.out.println("=======================================");
            String l_Input = keyboard.nextLine();
            switch (l_Input){
                case "edit" :
                    // setting phase as preload
                    setPhase(new Preload(this));
                    startMapEditor(keyboard);
                    break;
                case "play" :
                    // setting phase as playsetup
                    setPhase(new PlaySetup(this));
                    startMainPlay(keyboard);
                    break;
                case "quit" :
                    return;
            }

        }while(true);


        // can change the state of the context (Game Engine) object, e.g.

        //setPhase(new Preload(this));
        //setPhase(new PostLoad(this));

        // can trigger state independent behaviour by using the methods
        // define in the State(phase) object e.g.

        //TODO
        /*
        d_GamePhase.loadMap();
        d_GamePhase.reinforce();
        d_GamePhase.next();
        */

        /*
        for (int turn = 1; turn <= numTurns; turn++) {
            boolean an_order = true;
            do {
                for (ca.concordia.pattern.command.Player p : players) {
                    an_order = p.createOrder(map, players);
                    if (!an_order) {
                        break;
                    }
                }
            } while (an_order);
            executeAllOrders();
            printMap();
        }
        */
    }

    void startMapEditor(Scanner keyboard){
        do{
            System.out.println("===================================================================================================");
            System.out.println("| PHASE          : command         command arguments                                             |");
            System.out.println("| Any            : showmap                                                                       |");
            System.out.println("| Edit:          : editmap        <filepath>                                                     |");
            System.out.println("| Edit:PostLoad  : editcontinent  -add <continent-name> <continent-id> -remove <continent-name>  |");
            System.out.println("| Edit:PostLoad  : editcountry    -add <country-name> <continent-name> -remove <country-name>    |");
            System.out.println("| Edit:PostLoad  : editneighbor  -add <country-name> <neigbor> -remove <country-name> <neighbor> |");
            System.out.println("| Edit:PostLoad  : savemap        <filepath>                                                     |");
            System.out.println("| Edit:PostLoad  : validatemap                                                                   |");
            System.out.println("| Any            : quit                                                                          |");
            System.out.println("===================================================================================================");
            String l_EditInput = keyboard.nextLine();

            if("quit".equalsIgnoreCase(l_EditInput)){
                break;
            }

            if (l_EditInput.length() > 0) {
                String[] l_CommandArray = l_EditInput.trim().split(" ");
                if (l_CommandArray.length > 0) {
                    String l_FirstCommand = l_CommandArray[0].toLowerCase();
                    System.out.println("firstCommand : " + l_FirstCommand);

                    switch (l_FirstCommand) {
                        case COMMAND_EDIT_CONTINENT:
                            d_GamePhase.editContinent(l_CommandArray);
                            break;

                        case COMMAND_EDIT_COUNTRY:
                            d_GamePhase.editCountry(l_CommandArray);
                            break;

                        case COMMAND_EDIT_NEIGHBOUR:
                            d_GamePhase.editNeighbour(l_CommandArray);
                            break;

                        case COMMAND_SHOW_MAP:
                            d_GamePhase.showMap();
                            break;

                        case COMMAND_SAVE_MAP:
                            d_GamePhase.saveMap(l_CommandArray);
                            break;

                        case COMMAND_EDIT_MAP:
                            d_GamePhase.editMap(l_CommandArray);
                            break;

                        case COMMAND_VALIDATE_MAP:
                            d_GamePhase.validateMap(l_CommandArray);
                            break;


                        default:
                            System.out.println("INVALID COMMAND in edit phase");
                    }
                }
            }



        }while (true);
    }


    void startMainPlay(Scanner keyboard){
        do {

            System.out.println("============================================================================================");
            System.out.println("| PHASE                : command         command arguments                                 |");
            System.out.println("| Any                  : showmap                                                           |");
            System.out.println("| Play:PlaySetup       : loadmap         <filepath>                                        |");
            System.out.println("| Play:PlaySetup       : gameplayer      -add <player-name>                                |");
            System.out.println("| Play:PlaySetup       : assigncountries                                                   |");
            System.out.println("| Play:MainPlay:Order  : deploy          <country-name> <num-of-armies>                    |");
            System.out.println("| Play:MainPlay:Order  : advance         <country-from> <country-to> <num-of-armies>       |");
            System.out.println("| Play:MainPlay:Order  : bomb            <country-name>                                    |");
            System.out.println("| Play:MainPlay:Order  : blockade        <country-name>                                    |");
            System.out.println("| Play:MainPlay:Order  : airlift         <source-country> <target-country> <num-of-armies> |");
            System.out.println("| Play:MainPlay:Order  : negotiate       <player-name>                                     |");
            System.out.println("| Any                  : quit                                                              |");
            System.out.println("============================================================================================");

            String l_GameInput = keyboard.nextLine();

            if("quit".equalsIgnoreCase(l_GameInput)){
                break;
            }

            if (l_GameInput.length() > 0) {
                String[] l_CommandArray = l_GameInput.trim().split(" ");
                if (l_CommandArray.length > 0) {
                    String l_FirstCommand = l_CommandArray[0].toLowerCase();
                    System.out.println("firstCommand : " + l_FirstCommand);

                    switch (l_FirstCommand) {



                        case COMMAND_LOAD_MAP:
                            d_GamePhase.loadMap(l_CommandArray);
                            break;

                        case COMMAND_GAME_PLAYER:
                            break;

                        case COMMAND_ASSIGN_COUNTRIES:
                            break;

                        case COMMAND_SHOW_MAP:
                            d_GamePhase.showMap();
                            break;

                        case COMMAND_DEPLOY:
                            System.out.println("deploy");
                            break;

                        case COMMAND_ADVANCE:
                            System.out.println("advance");
                            break;

                        case COMMAND_BOMB:
                            System.out.println("bomb");
                            break;

                        case COMMAND_BLOCKADE:
                            System.out.println("blockade");
                            break;

                        case COMMAND_AIRLIFT:
                            System.out.println("airlift");
                            break;

                        case COMMAND_NEGOTIATE:
                            System.out.println("negotiate");
                            break;

                        default:
                             System.out.println("INVALID COMMAND in play phase");
                    }
                }
            }
        }while(true);
    }

    /**
     * Helper method to process loadmap command to start the game play on a map
     *
     * @param p_Command command array
     */
    private void processLoadGameCommand(String[] p_Command) {
        System.out.println("load map to start game ..");
        try {
            String l_Filename = p_Command[1];
            if (!l_Filename.isEmpty()) {
                System.out.println("loadmap command received ..");
                File l_MapFile = new File(l_Filename);
                if (l_MapFile.exists()) {
                    Map l_Map = MapEditor.getInstance().readMapFile(l_MapFile);
                    GameEngine l_GameEngine = new GameEngine();
                    l_GameEngine.loadMapforGame();
                } else {
                    System.out.println("The map file" + l_MapFile.getAbsolutePath() + "doesn't exists");
                }
            }
        } catch (Exception p_E) {
            p_E.printStackTrace();
        }
    }


    void executeAllOrders() {
        /*
        Order order;
        boolean still_more_orders = false;
        do {
            still_more_orders = false;
            for (ca.concordia.pattern.command.Player p : players) {
                order = p.getNextOrder();

                if (order != null) {
                    still_more_orders = true;
                    order.printOrder();
                    order.execute();
                }
            }
        } while (still_more_orders);

         */
    }

    /**
     * game starts with loading of user-saved map file, which loads the map
     * as a "connected-directed-graph"
     */
    public void loadMapforGame() {
        this.d_Graph = this.d_CurrentMap.getAdjacencyMatrix();
        GAME_STARTED = true;
        System.out.println("Game engine has loaded the map");

        waitingForInput();


    }

    /**
     * Helper method to take commands for game engine
     */
    private void waitingForInput() {
        Scanner l_Scanner = new Scanner(System.in);
        while (true) {
            int l_PlayerListSize = this.d_PlayerActions.getListOfPlayers().size();
            System.out.println("number of players available is : " + l_PlayerListSize);
            System.out.println("use command \"gameplayer -add playername -remove playername \" " +
                    "to add between 3 to 5 players");
            System.out.println("use command \"assigncountries\" to start turn based main-loop");
            System.out.println("use command \"exit\" to stop game engine");
            String l_Input = l_Scanner.nextLine();
            System.out.println("input: " + l_Input);
            if ("exit".equalsIgnoreCase(l_Input)) {
                break;
            } else if (!GAME_STARTED) {
                System.out.println("game is finished, stopping ..");
                break;
            } else {
                if (l_Input.length() > 0) {
                    String[] l_CommandArray = l_Input.trim().split(" ");
                    if (processCommands2(l_CommandArray)) {
                        mainGameLoop();
                    }
                }
            }
        }
    }

    /**
     * helper method to process commands for game engine
     *
     * @param p_Command commands applicable into game play
     */
    private boolean processCommands2(String[] p_Command) {
        boolean l_BreakLoop = false;
        try {
            if (p_Command.length > 0) {
                String l_firstCommand = p_Command[0].toLowerCase();
                System.out.println("firstCommand : " + l_firstCommand);

                switch (l_firstCommand) {

                    case COMMAND_SHOW_MAP:
                        showMapforGame();
                        break;

                    case COMMAND_GAME_PLAYER:
                        processGamePlayerCommand(p_Command);
                        break;

                    case COMMAND_ASSIGN_COUNTRIES:
                        l_BreakLoop = processAssignCountriesCommand();
                        break;
                    default:
                        System.out.println("Invalid command");
                }
            }
        } catch (Exception l_E) {
            l_E.printStackTrace();
        }
        return l_BreakLoop;
    }

    /**
     * triggers on "showmap" command, this is a different function than MapEditors' showmap commad
     * as it shows extra details like :
     * 1. show all countries
     * 2. show all continents
     * 3. Armies on each countries
     * 4. Ownership
     * 5. Connectivity in a way that enables game-play
     */
    public void showMapforGame() {
        System.out.println("show game command received ");
        Graph l_Graph = d_CurrentMap.getAdjacencyMatrix();
        System.out.println(l_Graph.toString());
        for (Player l_Player : this.d_PlayerActions.getListOfPlayers()) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            System.out.println("PLAYER: " + l_Player.getPlayerName());
            System.out.println("with total army count of : " + l_Player.getNoOfArmies());
            System.out.println("has ownership of these countries: ");
            if (l_Player.getListOfCountries() != null) {
                for (Country l_Country : l_Player.getListOfCountries()) {
                    System.out.println("id: " + l_Country.getCountryID()
                            + " name: " + l_Country.getName()
                            + " army count: " + l_Country.getArmyCount()
                            + " belongs to continent " + l_Country.getContinentID());
                }
            }
        }
    }

    /**
     * Main Game loop that does three things for each player:
     * 1. Assign reinforcements
     * 2. Issue Orders
     * 3. Execute Orders
     * <p>
     * (After above three steps, it self-exit the game.)
     */

    private void mainGameLoop() {
        GAME_STARTED = true;
        while (true) {
            assignReinforcementPhase();
            issueOrderPhase();
            executeOrderPhase();
            if (this.d_PlayerActions.isGameOver() || GAME_STARTED == false) {
                System.out.println("GAME OVER");
                GAME_STARTED = false;
                break;
            }
        }
        Player l_Winner = this.d_PlayerActions.getWinner();
        if (l_Winner != null) {
            System.out.println("Winner is player > id: " + d_PlayerActions.getWinner().getPlayerID() + " name: " + d_PlayerActions.getWinner().getPlayerName());
        } else {
            System.out.println("Unknown winner ..");
        }
    }

    /***
     *
     * Assign to each player the correct number of reinforcement armies, according to Warzone rules
     */
    private void assignReinforcementPhase() {
        for (Player l_Player : this.d_PlayerActions.getListOfPlayers()) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("ASSIGN REINFORCEMENT PHASE : " + l_Player.getPlayerName());
            this.d_PlayerActions.assignReinforcementPhase(l_Player);
        }

    }

    /**
     * The GameEngine class calls the issue_order() method of the Player.
     * This method will wait for the following command, then create a deploy order object
     * on the player’s list of orders, then reduce the number of armies in the player’s reinforcement pool.
     * The game engine does this for all players in round-robin fashion until all the players have placed
     * all their reinforcement armies on the map.
     * Issuing order command:
     * deploy countryID num (until all reinforcements have been placed)
     */
    private void issueOrderPhase() {
        for (Player l_Player : this.d_PlayerActions.getListOfPlayers()) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("ISSUE ORDER PHASE : " + l_Player.getPlayerName());
            this.d_PlayerActions.issueOrdersPhase(l_Player);
            Scanner l_Scanner = new Scanner(System.in);
            while (true) {
                System.out.println("use command like [\"showmap\" ,  \"deploy <countryid> <num>\" , \"exit\" ");
                String l_Input = l_Scanner.nextLine();
                System.out.println("input: " + l_Input);
                if (l_Input.length() > 0) {
                    String[] l_CommandArray = l_Input.trim().split(" ");
                    try {
                        String l_Command = l_CommandArray[0];
                        if ((COMMAND_DEPLOY).equalsIgnoreCase(l_Command)) {
                            processDeployCommand(l_Player, l_CommandArray);
                            System.out.println("armies left to deply are : " + l_Player.getNoOfArmies());
                            if (l_Player.getNoOfArmies() < 1) {
                                System.out.println("All the reinforcement armies have been placed ..");
                                break;
                            }
                        } else if ((COMMAND_SHOW_MAP).equalsIgnoreCase(l_Command)) {
                            showMapforGame();
                        } else if ("exit".equalsIgnoreCase(l_Command)) {
                            GAME_STARTED = false;
                            break;
                        }
                    } catch (Exception l_E) {
                        l_E.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * The GameEngine calls the next_order() method of the Player. Then the Order object’s execute() method
     * is called, which will enact the order. The effect of a deploy order is to place num armies on
     * the country countryID.
     */
    private void executeOrderPhase() {
        for (Player l_Player : this.d_PlayerActions.getListOfPlayers()) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("EXECUTE ORDER  PHASE : " + l_Player.getPlayerName());
            this.d_PlayerActions.executeOrderPhase(l_Player);
        }
    }

    /**
     * helper method to take "gameplayer command to add or remove palyers"
     *
     * @param p_Command command array to process
     */
    private void processGamePlayerCommand(String[] p_Command) {
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
     * @param p_PlayerName playername to add
     * @return boolean
     */
    public boolean addPlayer(String p_PlayerName) {
        int l_Count = 0;
        for (Player l_Player : d_Instance.d_PlayerActions.getListOfPlayers()) {
            l_Count++;
            if (l_Player.getPlayerName().equalsIgnoreCase(p_PlayerName)) {
                System.out.println("A player with name: " + p_PlayerName + " already exists!");
                return false;
            }
        }
        Player l_NewPlayer = new Player(p_PlayerName, l_Count);
        return d_Instance.d_PlayerActions.addPlayer(l_NewPlayer);
    }

    /**
     * takes playerName and if it is found in existing playerlist, remove it .
     *
     * @param p_PlayerName playername to remove
     * @return boolean
     */
    public boolean removePlayer(String p_PlayerName) {
        for (Player l_Player : d_Instance.d_PlayerActions.getListOfPlayers()) {
            if (l_Player.getPlayerName().equalsIgnoreCase(p_PlayerName)) {
                return d_Instance.d_PlayerActions.removePlayer(l_Player);
            }
        }
        System.out.println("player not found : " + p_PlayerName);
        return false;
    }

    /**
     * helper method to process assigncountries command
     */
    private boolean processAssignCountriesCommand() {
        System.out.println("assigncountries command received..");
        try {
            int l_NumberOfPlayers = this.d_PlayerActions.getListOfPlayers().size();
            if (l_NumberOfPlayers >= 3 && l_NumberOfPlayers <= 5) {
                System.out.println("number of countries between [3 to 5] so assign countries to player now ..");
                return assignCountries();
            } else {
                System.out.println("number of player must be between [3 to 5] to state main-game-loop");
            }

        } catch (Exception l_E) {
            l_E.printStackTrace();
        }
        return false;
    }

    /**
     * All countries are assigned randomly to the player
     *
     * @return boolean
     */
    public boolean assignCountries() {
        return this.d_PlayerActions.assignCountriesToPlayers();
    }


    /**
     * Helper method to process deploy command
     *
     * @param p_Player  playername
     * @param p_Command actions for the player e.g. deploy
     */
    private void processDeployCommand(Player p_Player, String[] p_Command) {
        System.out.println("deploy  command received ..... ");
        try {
            if (p_Command.length == 3) {
                String l_CountryName = p_Command[1];
                String l_Num = p_Command[2];
                int l_NumInt = Integer.parseInt(l_Num);
                int l_ArmyCountOfPlayer = p_Player.getNoOfArmies();
                if (l_ArmyCountOfPlayer >= l_NumInt) {
                    p_Player.setNoOfArmies(l_ArmyCountOfPlayer - l_NumInt);
                    Order2 l_order2 = new Order2(COMMAND_DEPLOY, l_CountryName, l_NumInt);
                    p_Player.addNewOrder(l_order2);
                } else {
                    System.out.println("TRY AGAIN: only " + l_ArmyCountOfPlayer + " is available to be deployed !");
                }
            }
        } catch (Exception l_E) {
            l_E.printStackTrace();
        }
    }

}