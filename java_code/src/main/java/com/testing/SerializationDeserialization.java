package com.testing;

import java.io.*;

// Example class to serialize/deserialize
class Person implements Serializable {
    private static final long serialVersionUID = 1L; // Important for versioning
    String name;
    int age;
    transient String secret; // Example of a transient field

    public Person(String name, int age, String secret) {
        this.name = name;
        this.age = age;
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "com.testing.Person{name='" + name + "', age=" + age + ", secret='" + secret + "'}";
    }
}

public class SerializationDeserialization {

    public static void main(String[] args) {
        Person person = new Person("Alice", 30, "topSecret");

        // Serialization
        try (FileOutputStream fileOut = new FileOutputStream("person.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person);
            System.out.println("Serialized data is saved in person.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

        // Deserialization
        Person deserializedPerson = null;
        try (FileInputStream fileIn = new FileInputStream("person.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            deserializedPerson = (Person) in.readObject();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("com.testing.Person class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized com.testing.Person:");
        System.out.println(deserializedPerson);
    }
}