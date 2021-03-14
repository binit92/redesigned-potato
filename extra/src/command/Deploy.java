package command;

//Concrete Command for Command pattern
public class Deploy implements Order {
    Territory target_territory;
    int to_deploy;
    Player initiator;

    public Deploy(Player initiator, Territory target_territory, int to_deploy) {
        // encapsulate all necessary data to execute the command
        this.target_territory = target_territory;
        this.initiator = initiator;
        this.to_deploy = to_deploy;
    }

    public void execute() {
        // Here, the target Territory object is the Receiver
        if (valid()) {
            // behavior of the concrete command
            this.target_territory numArmies += to_deploy;
        }
    }

    public boolean valid() {
        if (target_territory.owner.equals(initiator) {
            // the target territory must belong to the player that created the order
            return true;
        }else{
            System.out.println("invalid order");
            return false;
        }
    }

    public void printOrder() {
        System.out.println("Deploy order issued by player " + this initiator.name);
        System.out.println("Deploy " + this to_deploy + " to " + this target_territory.name);
    }
}
