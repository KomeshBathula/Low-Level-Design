package BehaviouralDesignPatterns.VisitorPattern;

interface Product {
    void accept(Visitor visitor);
}

interface Visitor {

    void visit(Laptop laptop);

    void visit(Mobile mobile);

    void visit(Headphones headphones);
}

class Laptop implements Product {

    private double price;

    public Laptop(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Mobile implements Product {

    private double price;

    public Mobile(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Headphones implements Product {

    private double price;

    public Headphones(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class DiscountVisitor implements Visitor {

    @Override
    public void visit(Laptop laptop) {

        double discount = laptop.getPrice() * 0.10;

        System.out.println("Laptop Discount : $" + discount);
    }

    @Override
    public void visit(Mobile mobile) {

        double discount = mobile.getPrice() * 0.05;

        System.out.println("Mobile Discount : $" + discount);
    }

    @Override
    public void visit(Headphones headphones) {

        double discount = headphones.getPrice() * 0.20;

        System.out.println("Headphones Discount : $" + discount);
    }
}


public class Main {

    public static void main(String[] args) {

        Product laptop = new Laptop(1000);

        Product mobile = new Mobile(500);

        Product headphones = new Headphones(200);

        Visitor discountVisitor = new DiscountVisitor();

        laptop.accept(discountVisitor);

        mobile.accept(discountVisitor);

        headphones.accept(discountVisitor);
    }
}