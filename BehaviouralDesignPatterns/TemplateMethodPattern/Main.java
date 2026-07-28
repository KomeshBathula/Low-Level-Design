package BehaviouralDesignPatterns.TemplateMethodPattern;

abstract class Beverage {

    public final void makeDrink() {

        boilWater();

        addIngredients();

        pourIntoCup();

        addExtras();
    }

    public void boilWater() {
        System.out.println("Boiling Water");
    }

    public void pourIntoCup() {
        System.out.println("Pouring into Cup");
    }

    abstract void addIngredients();

    abstract void addExtras();
}

class Tea extends Beverage {

    @Override
    void addIngredients() {
        System.out.println("Adding Tea Leaves");
    }

    @Override
    void addExtras() {
        System.out.println("Adding Sugar");
    }
}

class Coffee extends Beverage {

    @Override
    void addIngredients() {
        System.out.println("Adding Coffee Powder");
    }

    @Override
    void addExtras() {
        System.out.println("Adding Milk");
    }
}

public class Main {

    public static void main(String[] args) {

        Beverage tea = new Tea();

        tea.makeDrink();

        System.out.println();

        Beverage coffee = new Coffee();

        coffee.makeDrink();
    }
}