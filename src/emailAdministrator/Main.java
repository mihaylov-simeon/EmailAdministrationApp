package emailAdministrator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee names: \n");

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();

        Email email = new Email(firstName, lastName);

        email.changeEmailOrPassword();
    }
}