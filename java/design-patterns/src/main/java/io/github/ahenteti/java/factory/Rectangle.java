package io.github.ahenteti.java.factory;

public class Rectangle implements IDrawable {
    @Override
    public void draw() {
        System.out.println("I'm a rectangle");
    }
}
