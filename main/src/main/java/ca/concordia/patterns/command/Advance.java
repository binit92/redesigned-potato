package ca.concordia.patterns.command;

//   ConcreteCommand of the the Command pattern.
public class Advance implements Order{

    //Territory source;
    //Territory target;
    //Player initiator;
    //int num_to_advance;

    /*
    Advance(Player initiator, Territory source, Territory target, int num) {

        // encapsulate all necessary data to execute the command
        this.initiator = initiator;
        this.source = source;
        this.target = target;
        this.num_to_advance = num;
    }

     */

    public void execute() {
        // Here both the source and the target Territories are Receivers
        System.out.println("advance execute ");
        /*
        if (valid()) {
            if (target.owner.equals(initiator)) {
                // if the source and the target belong to the same player
                // then just move the armies to the target Territory
            } else {
                // implement a battle
                if (target.numArmies < 0) {
                    // move surviving attacking armies to the target country
                    // transfer ownership of the conquered country
                }
            }
        }

         */
    }

    public boolean valid() {
        if (valid()) {
            return true;
        } else {

            System.out.println("invalid order");
            return false;
        }

    }

    public void printOrder() {
        // print the order
    }
}
