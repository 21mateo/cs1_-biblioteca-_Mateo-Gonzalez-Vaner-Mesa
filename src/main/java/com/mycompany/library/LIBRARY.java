package com.mycompany.library;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Mateo Gonzalez
 */
public class LIBRARY {
    public static List<Person> People = new ArrayList<>();
    public static List<Material> Materials = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        People.add(new Student("Juan Gallego", 18, "juan.gallego22@mail.tdea.edu.co"));
        People.add(new Teaching("Cristina Castro", 35, "cristina.castro@mail.tdea.edu.co"));
        People.add(new Administrator("Mario lopez", 50, "mario.lopez12@mail.tdea.edu.co"));

        Materials.add(new Book("Programacion en Java"));
        Materials.add(new Magazine("Ciencia Hoy"));
        Materials.add(new Audiovisual("Documental de Historia"));

        int option;
        do {
            System.out.println("\n--- Menu de la Biblioteca ---");
            System.out.println("1. Registrar una persona");
            System.out.println("2. Eliminar una persona");
            System.out.println("3. Actualizar una persona");
            System.out.println("4. Registrar un material");
            System.out.println("5. Reservar un material");
            System.out.println("6. Renovar un material");
            System.out.println("7. Devolver un material");
            System.out.println("8. Salir");
            System.out.print("Elija una option: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    registerPerson(scanner);
                    break;
                case 2:
                    deletePerson(scanner);
                    break;
                case 3:
                    updatePerson(scanner);
                    break;
                case 4:
                    registerMaterial(scanner);
                    break;
                case 5:
                    manageMaterial(scanner, "reservar");
                    break;
                case 6:
                    manageMaterial(scanner, "renovar");
                    break;
                case 7:
                    manageMaterial(scanner, "devolver");
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 8);
        scanner.close();
    }
    public static void registerPerson(Scanner scanner) {
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Edad: ");
        int age = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Correo: ");
        String mail = scanner.nextLine();
        System.out.print("Tipo (1. Estudiante, 2. Docente, 3. Administrador): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); 

        switch (tipo) {
            case 1:
                People.add(new Student(name, age, mail));
                break;
            case 2:
                People.add(new Teaching(name, age, mail));
                break;
            case 3:
                People.add(new Administrator(name, age, mail));
                break;
            default:
                System.out.println("Tipo no valido.");
        }
        System.out.println("Persona registrada exitosamente.");
    }
    public static void deletePerson(Scanner scanner) {
        listPeople();
        System.out.print("Ingrese el número de la persona a eliminar: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < People.size()) {
            People.remove(index);
            System.out.println("Persona eliminada.");
        } else {
            System.out.println("Indice no válido.");
        }
    }
    public static void updatePerson(Scanner scanner) {
        listPeople();
        System.out.print("Ingrese el número de la persona a actualizar: ");
        int index = scanner.nextInt();
        scanner.nextLine(); 
        if (index >= 0 && index < People.size()) {
            Person p1 = People.get(index);
            System.out.print("Nuevo name: ");
            p1.name = scanner.nextLine();
            System.out.print("Nueva age: ");
            p1.age = scanner.nextInt();  
            scanner.nextLine();  
            System.out.print("Nuevo mail: ");
            p1.mail = scanner.nextLine(); 
            System.out.println("Persona actualizada.");
        } else {
            System.out.println("Indice no válido.");
        }
    }
    public static void registerMaterial(Scanner scanner) {
        System.out.print("Titulo del material: ");
        String titulo = scanner.nextLine();
        System.out.print("Tipo de material (1. Libro, 2. Revista, 3. Audiovisual): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); 

        switch (tipo) {
            case 1:
                Materials.add(new Book(titulo));
                break;
            case 2:
                Materials.add(new Magazine(titulo));
                break;
            case 3:
                Materials.add(new Audiovisual(titulo));
                break;
            default:
                System.out.println("Tipo de material no valido.");
        }
        System.out.println("Material registrado exitosamente.");
    }
    public static void manageMaterial(Scanner scanner, String accion) {
        listMaterials();
        System.out.print("Ingrese el número del material: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < Materials.size()) {
            Material material = Materials.get(index);
            switch (accion) {
                case "reservar":
                    material.reserve();
                    break;
                case "renovar":
                    material.renew();
                    break;
                case "devolver":
                    material.repay();
                    break;
                default:
                    System.out.println("Acción no válida.");
            }
        } else {
            System.out.println("Indice no válido.");
        }
    }
    public static void listPeople() {
        if (People.isEmpty()) {
            System.out.println("No hay People registradas.");
        } else {
            for (int i = 0; i < People.size(); i++) {
                System.out.println(i + ". " + People.get(i));
            }
        }
    }
    public static void listMaterials() {
        if (Materials.isEmpty()) {
            System.out.println("No hay Materials disponibles.");
        } else {
            for (int i = 0; i < Materials.size(); i++) {
                System.out.println(i + ". " + Materials.get(i).title + " (Disponible: " + Materials.get(i).available + ")");
            }
        }
    }
}
