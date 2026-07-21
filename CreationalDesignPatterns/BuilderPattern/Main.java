package CreationalDesignPatterns.BuilderPattern;

public class Main {
    public static void main(String[] args) {

        Laptop laptop =
                new Laptop.Builder("Dell", "i7")
                        .ram(16)
                        .ssd(512)
                        .touchScreen(true)
                        .build();

        System.out.println(laptop);
    }   
}
