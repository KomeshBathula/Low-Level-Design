package CreationalDesignPatterns.AbstractFactoryPattern;

public class Main {

    public static void main(String[] args) {

        UIFactory factory = new WindowsFactory();

        Button button = factory.createButton();

        Checkbox checkbox = factory.createCheckbox();

        button.paint();

        checkbox.paint();
    }
}
