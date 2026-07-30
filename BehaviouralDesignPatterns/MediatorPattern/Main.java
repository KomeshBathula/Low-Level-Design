package BehaviouralDesignPatterns.MediatorPattern;

import java.util.ArrayList;
import java.util.List;

interface DocumentMediator {

    void sendMessage(String message, User sender);

    void addUser(User user);
}

abstract class User {

    protected String name;

    protected DocumentMediator mediator;

    public User(String name, DocumentMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public abstract void receiveMessage(String message);
}

class EditorUser extends User {

    public EditorUser(String name, DocumentMediator mediator) {
        super(name, mediator);
    }

    @Override
    public void receiveMessage(String message) {

        System.out.println(name + " received: " + message);

    }
}

class DocumentMediatorImpl implements DocumentMediator {

    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {

        for(User user : users) {

            if(user != sender) {

                user.receiveMessage(sender.name + " edited document: " + message);

            }

        }

    }
}


public class Main {

    public static void main(String[] args) {

        DocumentMediator mediator = new DocumentMediatorImpl();

        User alice = new EditorUser("Alice", mediator);

        User bob = new EditorUser("Bob", mediator);

        User charlie = new EditorUser("Charlie", mediator);

        mediator.addUser(alice);
        mediator.addUser(bob);
        mediator.addUser(charlie);

        alice.sendMessage("Added Introduction");

        System.out.println();

        bob.sendMessage("Corrected Grammar");
    }
}
