package StructuralDesignPatterns.CompositePattern;

public class Main {

    public static void main(String[] args) {

        File file1 = new File("Resume.pdf", 5);

        File file2 = new File("Notes.txt", 2);

        File file3 = new File("Photo.jpg", 3);

        Folder images = new Folder("Images");

        images.add(file3);

        Folder documents = new Folder("Documents");

        documents.add(file1);

        documents.add(file2);

        documents.add(images);

        documents.showDetails();

        System.out.println();

        System.out.println("Total Size = " + documents.getSize() + " MB");
    }
}
