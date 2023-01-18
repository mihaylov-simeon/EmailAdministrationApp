package emailAdministrator;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private static final String COMPANY_SUFFIX = "company.com";

    private static final int PASSWORD_LENGTH = 24;

    // constructor takes only firstName and lastName
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New email created: " + this.firstName + " " + this.lastName);

        // call a method that asking for the department and return the department by the department code entered
        this.department = setDepartment();
        System.out.print("Department: " + this.department + "\n");

        // call a method to generate a random password each time
        this.password = generateRandomPassword(PASSWORD_LENGTH);
        System.out.println("Your password is: " + this.password);

        // generate an actual email by specifications -> firstname.lastname@department.company.com
        email = firstName.toLowerCase()
                + "." + lastName.toLowerCase()
                + "@" + department.toLowerCase()
                + "." + COMPANY_SUFFIX;
        System.out.println("Your email is: " + email);
    }

    private String setDepartment() {
        System.out.print("""
                Department codes:
                1. Sales
                2. Accounting
                3. IT
                4. HR
                Enter department code:\s""");
        Scanner scanner = new Scanner(System.in);
        int departmentChoice = scanner.nextInt();

        return switch (departmentChoice) {
            case 1 -> "sales";
            case 2 -> "accounting";
            case 3 -> "IT";
            case 4 -> "HR";
            default -> "n/a";
        };
    }

    // generate a random password
    private String generateRandomPassword(int length) {
        // create all the available symbols for a password
         String setPassword = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890~!@#$%^&*()_+{}|[]/;:,.<>";
         // create a new char array with the password length
         char[] password = new char[length];
         // numbers from 0 to 1
        for (int i = 0; i < length; i++) {
            // generate a random password by multiplying the numbers by the symbols length
            int randomPassword = (int) (Math.random() * setPassword.length());
            // make each symbol be equal to the randomly generated symbol
            password[i] = setPassword.charAt(randomPassword);
        }
        // make the password into a new String because it's in characters
        return new String(password);
    }

    // set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // set the alternative email
    public void changeEmailOrPassword() {
        System.out.print("""
                \nEmployee codes:
                1. Change password
                2. Change email
                Enter employee code:\s""");
        Scanner scanner = new Scanner(System.in);
        int employeeCode = scanner.nextInt();

        if (employeeCode == 1) {
            changePassword();
        } else if (employeeCode == 2) {
            email = lastName.toLowerCase()
                    + "." + firstName.toLowerCase()
                    + "@" + department.toLowerCase()
                    + "." + COMPANY_SUFFIX;
            System.out.println("Your alternative email is: " + email);
        }
    }

    // change the password
    private void changePassword() {
        System.out.println("Your new Password is: "
                + generateRandomPassword(PASSWORD_LENGTH));
    }
}
