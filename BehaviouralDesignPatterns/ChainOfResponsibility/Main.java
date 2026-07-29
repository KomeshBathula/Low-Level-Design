package BehaviouralDesignPatterns.ChainOfResponsibility;

abstract class SupportHandler {

    protected SupportHandler nextHandler;

    public void setNext(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String issue);
}


class Level1Support extends SupportHandler {

    @Override
    public void handleRequest(String issue) {

        if(issue.equalsIgnoreCase("password")) {
            System.out.println("Level 1 solved Password Issue");
        }
        else if(nextHandler != null) {
            nextHandler.handleRequest(issue);
        }
    }
}

class Level2Support extends SupportHandler {

    @Override
    public void handleRequest(String issue) {

        if(issue.equalsIgnoreCase("refund")) {
            System.out.println("Level 2 solved Refund Issue");
        }
        else if(nextHandler != null) {
            nextHandler.handleRequest(issue);
        }
    }
}

class ManagerSupport extends SupportHandler {

    @Override
    public void handleRequest(String issue) {

        if(issue.equalsIgnoreCase("legal")) {
            System.out.println("Manager solved Legal Issue");
        }
        else {
            System.out.println("Issue cannot be resolved.");
        }
    }
}


public class Main {

    public static void main(String[] args) {

        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler manager = new ManagerSupport();

        level1.setNext(level2);
        level2.setNext(manager);

        level1.handleRequest("password");

        System.out.println();

        level1.handleRequest("refund");

        System.out.println();

        level1.handleRequest("legal");

        System.out.println();

        level1.handleRequest("network");
    }
}