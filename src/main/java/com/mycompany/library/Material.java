package com.mycompany.library;

/**
 *
 * @author Mateo Gonzalez
 */
public class Material {
    public String title;
    public boolean available;

    public Material(String title) {
        this.title = title;
        this.available = true;
    }
    

    public void reserve(){
        if(available){
            available = false;
            System.out.println("El Material " + title + " ha sido reservado.");
        }else{
            System.out.println("El Material " + title + " no esta disponible.");
        }
    
    }

    public void renew(){
        System.out.println("El Material " + title + " ha sido renovado.");
    }
    

    public void repay(){
        available = true;
        System.out.println("El Material " + title + " ha sido devuelto.");
    }
}
