package com.example.cw4;

public class OuterClass {
    private String outerField = "Outer field";
    private static String staticOuterField = "Static outer field";

    // Inner Class
    class InnerClass {
        void display() {
            System.out.println("Inner Class: " + outerField);
        }
    }

    // Static Nested Class
    static class NestedStaticClass {
        void display() {
            System.out.println("Static Nested Class: " + staticOuterField);
        }
    }

    public void performAction() {
        // Local Inner Class
        class LocalClass {
            void display() {
                System.out.println("Local Inner Class: " + outerField);
            }
        }
        LocalClass local = new LocalClass();
        local.display();
    }

    // Anonymous class
    abstract static class Greeter {
        abstract void greet();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();

        // Inner Class
        InnerClass inner = outer.new InnerClass();
        inner.display();

        // Static Nested Class
        NestedStaticClass nested = new NestedStaticClass();
        nested.display();

        // Local Inner Class
        outer.performAction();

        // Anonymous Inner Class
        Greeter greeter = new Greeter() {
            void greet() {
                System.out.println("Hello from an anonymous class.");
            }
        };
        greeter.greet();
    }
}
