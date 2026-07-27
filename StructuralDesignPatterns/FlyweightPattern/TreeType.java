package StructuralDesignPatterns.FlyweightPattern;

public class TreeType {

    private String name;
    private String color;

    public TreeType(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void draw(int x, int y) {
        System.out.println(
                "Drawing " + name +
                " Tree at (" + x + "," + y + ")" +
                " Color: " + color
        );
    }
}