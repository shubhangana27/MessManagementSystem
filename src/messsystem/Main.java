package messsystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MessSystem mess = new MessSystem();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("======================================");
        System.out.println("     MESS MANAGEMENT SYSTEM");
        System.out.println("======================================");
        
        while(true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. View Full Menu");
            System.out.println("2. View Menu with Ratings");
            System.out.println("3. Rate a Meal");
            System.out.println("4. View Statistics");
            System.out.println("5. Most Popular Dish");
            System.out.println("6. Admin - Update Menu");
            System.out.println("7. Exit");
            System.out.print("\nChoose option (1-7): ");
            
            int choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    mess.displayFullMenu();
                    break;
                case 2:
                    mess.displayMenuWithRatings();
                    break;
                case 3:
                    mess.rateMeal();
                    break;
                case 4:
                    mess.showStatistics();
                    break;
                case 5:
                    mess.showMostPopularDish();
                    break;
                case 6:
                    mess.adminUpdateMenu();
                    break;
                case 7:
                    System.out.println("\nThank you for using Mess Management System!");
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please choose 1-7.");
            }
        }
    }
}