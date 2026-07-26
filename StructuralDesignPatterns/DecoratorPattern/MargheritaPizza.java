package StructuralDesignPatterns.DecoratorPattern;

public class MargheritaPizza implements Pizza{

    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 200;
    }
}
