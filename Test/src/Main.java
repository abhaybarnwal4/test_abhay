import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the password");
        String password = sc.nextLine();

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        if (password.length() < 8) {
            System.out.println("Invalid Pasword");
        }

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSpecial = true;
            }
        }

        if (hasUpper && hasLower && hasDigit && hasSpecial) {
            System.out.println("Valid Password");

        } else {
            System.out.println("Invalid Password");
        }
        sc.close();
    }
}


//Write a Java program to validate a password based on the following rules:
//
//        1. Minimum 8 characters
//
//2. At least 1 uppercase letter
//
//3. At least 1 lowercase letter
//
//4. At least 1 digit
//
//5. At least 1 special character (@ # $ % & *)
//
//If all rules are satisfied, print Valid Password, else print Invalid PasswordWrite a Java program to validate a password based on the following rules:
//
//        1. Minimum 8 characters
//
//2. At least 1 uppercase letter
//
//3. At least 1 lowercase letter
//
//4. At least 1 digit
//
//5. At least 1 special character (@ # $ % & *)
//
//If all rules are satisfied, print Valid Password, else print Invalid Password
//