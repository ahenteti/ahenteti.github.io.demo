package io.github.ahenteti.java.factory;

public class FactoryDemo {
    public static void main(String[] args) {
        DrawableFactory factory = new DrawableFactory();
        IDrawable circle = factory.create(EDrawable.CIRCLE);
        IDrawable square = factory.create(EDrawable.SQUARE);
        IDrawable rectangle = factory.create(EDrawable.RECTANGLE);
        circle.draw();    // I'm a circle
        square.draw();    // I'm a square
        rectangle.draw(); // I'm a rectangle
    }
}
