package admin;

import java.util.Scanner;

public class AdminMenu {

    public static void adminMenu() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1 Add Accountant");
            System.out.println("2 View Accountant");
            System.out.println("3 Logout");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    AddAccountant.addAccountant();
                    break;

                case 2:
                    ViewAccountant.viewAccountant();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}