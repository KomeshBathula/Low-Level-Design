package StructuralDesignPatterns.CompositePattern;

public class File implements FileSystemComponent {

    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println(name + " (" + size + " MB)");
    }

    @Override
    public int getSize() {
        return size;
    }
}
