package StructuralDesignPatterns.ProxyPattern;

public class ImageProxy implements Image {

    private String filename;

    private RealImage realImage;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {

        if (realImage == null) {
            realImage = new RealImage(filename);
        }

        realImage.display();
    }
}
