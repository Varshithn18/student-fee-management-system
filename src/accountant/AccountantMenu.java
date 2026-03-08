package accountant;

import java.util.Scanner;

public class AccountantMenu {

    public static void menu() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- ACCOUNTANT MENU ---");
            System.out.println("1 Add Student");
            System.out.println("2 View Students");
            System.out.println("3 Edit Student");
            System.out.println("4 Due Fee");
            System.out.println("5 Logout");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    AddStudent.addStudent();
                    break;

                case 2:
                    ViewStudent.viewStudent();
                    break;

                case 3:
                    EditStudent.editStudent();
                    break;

                case 4:
                    DueFee.showDueFee();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}