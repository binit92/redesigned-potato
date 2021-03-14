package command;

import java.util.List;

public class Player {
    public boolean createOrder(List<Territory> map, List<Player> players) {
        //…
        orders_list.add(new Deploy(this, target, num));
        orders_list.add(new Advance(this, source, target, num));
        orders_list.add(new Pacify(this, player));
        //…
        return  false;
    }

    public Order getNextOrder() {
        if (this.orders_list.isEmpty()){
            to_return = this.orders_list.get(0);
            this.orders_list.remove(0);
            return to_return;
        }else
        return null;
    }
}
