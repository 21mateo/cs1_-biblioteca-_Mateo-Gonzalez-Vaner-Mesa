/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library;

/**
 *
 * @author Mateo Gonzalez
 */
public class Teaching extends Person {

    public Teaching(String name, int age, String mail) {
        super(name, age, mail);
    }
    
    public String getType() {
        return "Docente";
    }
    
}
