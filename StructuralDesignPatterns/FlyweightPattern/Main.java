package StructuralDesignPatterns.FlyweightPattern;

public class Main {

    public static void main(String[] args) {

        Tree tree1 =
                new Tree(
                        10,
                        20,
                        TreeFactory.getTreeType(
                                "Oak",
                                "Green"));

        Tree tree2 =
                new Tree(
                        30,
                        50,
                        TreeFactory.getTreeType(
                                "Oak",
                                "Green"));

        Tree tree3 =
                new Tree(
                        60,
                        90,
                        TreeFactory.getTreeType(
                                "Pine",
                                "Dark Green"));

        tree1.draw();
        tree2.draw();
        tree3.draw();
    }
}
