package StructuralDesignPatterns.ProxyPattern;

public class Main {

    public static void main(String[] args) {

        Image image = new ImageProxy("Wallpaper.jpg");

        System.out.println("Proxy created.");
        System.out.println();

        System.out.println("First display:");
        image.display();

        System.out.println();

        System.out.println("Second display:");
        image.display();
    }
}
