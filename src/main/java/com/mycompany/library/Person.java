package com.mycompany.library;

/**
 * @author Mateo Gonzalez
 */
public class Person {
    public String name;
    public int age;
    public String mail;

    public Person(String name, int age, String mail) {
        this.name = name;
        this.age = age;
        this.mail = mail;
    }
    
    
    public String getType(){
        return "Person";
    }

    public String toString() {
        return "Nombre: " + name + ", Tipo: " + getType() + ", Edad: " + age + ", Correo: " + mail;
    }

}
