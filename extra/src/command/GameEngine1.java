package command;

import java.util.List;

// client for command pattern
public class GameEngine1 {

    List<Territory> map;
    List<Player> players;

    public void start() {
        for (int turn = 1; turn <= numTurns; turn++) {
            boolean an_order = true;
            do {
                for (Player p : players) {
                    an_order = p.createOrder(map, players);
                    if (!an_order) {
                        break;
                    }
                }
            } while (an_order);
            executeAllOrders();
            printMap();
        }
    }

    void executeAllOrders() {
        Order order;
        boolean still_more_orders = false;
        do {
            still_more_orders = false;
            for (Player p : players) {
                order = p.getNextOrder();

                if (order != null) {
                    still_more_orders = true;
                    order.printOrder();
                    order.execute();
                }
            }
        } while (still_more_orders);
    }
}