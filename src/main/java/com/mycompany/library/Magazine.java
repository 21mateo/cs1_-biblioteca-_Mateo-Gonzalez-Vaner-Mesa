/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library;

/**
 *
 * @author Mateo Gonzalez
 */
public class Magazine extends Material {

    public Magazine(String title) {
        super(title);
    }
    
     public void showInformation() {
        System.out.println("Revista: " + title);
    }
   
}
