package io.github.ahenteti.java.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        ComplexObject ob = new ComplexObject.Builder()
                .prop1("prop1") 
                .prop2("prop2") 
                .prop3(3) 
                .prop4("prop4") 
                .prop5(5)
                .build();
    }
}
