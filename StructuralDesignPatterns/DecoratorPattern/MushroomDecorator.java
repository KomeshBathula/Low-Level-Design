package StructuralDesignPatterns.DecoratorPattern;

public class MushroomDecorator extends PizzaDecorator {

    public MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {

        return pizza.getDescription() + ", Mushroom";

    }

    @Override
    public double getCost() {

        return pizza.getCost() + 40;

    }

}
