package ca.concordia.patterns.state.play;

import ca.concordia.dao.Player;
import ca.concordia.gameengine.GameEngine;
import ca.concordia.patterns.command.Order;

public class Fortify extends MainPlay {
    public Fortify(GameEngine p_ge) {
        super(p_ge);
    }

    public void next() {
        d_ge.setPhase(new Reinforcement(d_ge));
    }

    public void reinforce() {
        printInvalidCommandMessage();
    }

    public void attack() {
        printInvalidCommandMessage();
    }

    public void fortify() {

    }


    /**
     * @param p_Player "to be updated"
     */
    public void executeOrderPhase(Player p_Player) {
        //Order2 l_Order2 = p_Player.nextOrder();
        Order l_Order = p_Player.nextOrder();
        /*
        if (l_Order != null) {
            String l_OrderType = l_Order.getOrderType();
            switch (l_OrderType) {
                case "deploy":
                    String l_CountryName = l_Order2.getCountryName();
                    int l_ArmyCount = l_Order2.getArmyCount();
                    int l_PlayerArmyAvailable = p_Player.getNoOfArmies();
                    if (l_PlayerArmyAvailable < l_ArmyCount) {
                        System.out.println("Invalid: player " + p_Player.getPlayerName() + "cannot assign more armies than it has..");
                        l_ArmyCount = p_Player.getNoOfArmies();
                    }

                    for (Country l_country : d_map.getListOfCountries()) {
                        if (l_country.getName().equalsIgnoreCase(l_CountryName)) {
                            l_country.setArmyCount(l_ArmyCount);
                            p_Player.setNoOfArmies(l_PlayerArmyAvailable - l_ArmyCount);
                            System.out.println(l_ArmyCount + "  armies are deploy to the country: " + l_CountryName);
                            break;
                        }
                    }

                    break;
                default:
                    System.out.println(l_OrderType + " is not a valid order type to execute");
            }

         */
    }

}


