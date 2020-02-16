package io.github.ahenteti.java.factory;

public class DrawableFactory {
    public IDrawable create(EDrawable type) {
        switch (type) {
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();
            case RECTANGLE:
                return new Rectangle();
            default:
                throw new RuntimeException("unknown drawable type: " + type);
        }
    }
}
