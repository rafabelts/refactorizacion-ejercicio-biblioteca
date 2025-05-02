package sch.library.modules.user;

import java.util.List;
import java.util.Scanner;

import sch.library.utils.Service;

public class UserService implements Service<User> {

    private Scanner scanner = new Scanner(System.in);

    public void add(List<User> users) {
        System.out.println("--- REGISTRAR NUEVO USUARIO ---");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Nombre: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Teléfono: ");
        String phoneNumber = scanner.nextLine();

        User newUser = new User(id, name, email, phoneNumber);
        users.add(newUser);

        System.out.println("Usuario registrado con éxito.");

    }

    public void showAll(List<User> users) {
        System.out.println("--- LISTADO DE USUARIOS ---");

        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        for (User user : users) {
            printUserInfo(user);
        }
    }

    private void printUserInfo(User user) {
        System.out.println("ID: " + user.getId() + " | Nombre: " + user.getName()
                + " | Email: " + user.getEmail() + " | Teléfono: " + user.getPhoneNumber());
    }

}
