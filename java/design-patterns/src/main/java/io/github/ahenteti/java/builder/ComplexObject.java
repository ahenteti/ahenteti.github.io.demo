package io.github.ahenteti.java.builder;

public class ComplexObject {
    
    private String prop1;
    private String prop2;
    private int prop3;
    private String prop4;
    private int prop5;

    private ComplexObject(Builder builder) {
        prop1 = builder.prop1;
        prop2 = builder.prop2;
        prop3 = builder.prop3;
        prop4 = builder.prop4;
        prop5 = builder.prop5;
    }

    public static final class Builder {
        private String prop1;
        private String prop2;
        private int prop3;
        private String prop4;
        private int prop5;

        public Builder() {
        }

        public Builder prop1(String prop1) {
            this.prop1 = prop1;
            return this;
        }

        public Builder prop2(String prop2) {
            this.prop2 = prop2;
            return this;
        }

        public Builder prop3(int prop3) {
            this.prop3 = prop3;
            return this;
        }

        public Builder prop4(String prop4) {
            this.prop4 = prop4;
            return this;
        }

        public Builder prop5(int prop5) {
            this.prop5 = prop5;
            return this;
        }

        public ComplexObject build() {
            return new ComplexObject(this);
        }
    }
}
