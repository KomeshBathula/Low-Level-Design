package CreationalDesignPatterns.AbstractFactoryPattern;

public interface UIFactory {

    Button createButton();

    Checkbox createCheckbox();
}