package StructuralDesignPatterns.DecoratorPattern;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new MargheritaPizza();

        pizza = new CheeseDecorator(pizza);

        pizza = new MushroomDecorator(pizza);

        System.out.println(pizza.getDescription());

        System.out.println(pizza.getCost());
    }
}
