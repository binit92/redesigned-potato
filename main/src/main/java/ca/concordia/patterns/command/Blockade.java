package ca.concordia.patterns.command;

public class Blockade implements Order{
    @Override
    public void execute() {

    }

    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public void printOrder() {

    }
}
