package messsystem;

import java.util.*;
import java.io.*;

public class MessSystem {
    private List<DayMenu> weeklyMenu;
    private Scanner scanner;
    private final String DATA_FILE = "data/mess_data.txt";
    
    public MessSystem() {
        weeklyMenu = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadData();
    }
    
    private void initializeDefaultMenu() {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", 
                        "Friday", "Saturday", "Sunday"};
        
        for(String day : days) {
            DayMenu dayMenu = new DayMenu(day);
            
            switch(day) {
                case "Monday":
                    dayMenu.setBreakfast("Aloo Paratha, Curd");
                    dayMenu.setLunch("Dal Makhani, Jeera Rice, Roti");
                    dayMenu.setSnacks("Samosa, Chutney");
                    dayMenu.setDinner("Paneer Butter Masala, Naan");
                    break;
                case "Tuesday":
                    dayMenu.setBreakfast("Poha, Jalebi");
                    dayMenu.setLunch("Chole Bhature");
                    dayMenu.setSnacks("Fruit, Biscuits");
                    dayMenu.setDinner("Veg Biryani, Raita");
                    break;
                case "Wednesday":
                    dayMenu.setBreakfast("Sandwich, Juice");
                    dayMenu.setLunch("Rajma Chawal");
                    dayMenu.setSnacks("Dhokla");
                    dayMenu.setDinner("Aloo Gobhi, Roti");
                    break;
                case "Thursday":
                    dayMenu.setBreakfast("Upma, Sambar");
                    dayMenu.setLunch("Kadhi Pakora, Rice");
                    dayMenu.setSnacks("Cutlet, Sauce");
                    dayMenu.setDinner("Dal Tadka, Tandoori Roti");
                    break;
                case "Friday":
                    dayMenu.setBreakfast("Paratha, Pickle");
                    dayMenu.setLunch("Veg Thali");
                    dayMenu.setSnacks("Pakora, Chai");
                    dayMenu.setDinner("Shahi Paneer, Roti");
                    break;
                case "Saturday":
                    dayMenu.setBreakfast("Pancake, Syrup");
                    dayMenu.setLunch("Special Biryani");
                    dayMenu.setSnacks("Ice Cream");
                    dayMenu.setDinner("Chinese Noodles, Manchurian");
                    break;
                case "Sunday":
                    dayMenu.setBreakfast("Poori Bhaji");
                    dayMenu.setLunch("Buffet Special");
                    dayMenu.setSnacks("Pizza");
                    dayMenu.setDinner("Roti, Dal, Sabzi");
                    break;
            }
            weeklyMenu.add(dayMenu);
        }
    }
    
    public void displayFullMenu() {
        System.out.println("\n===== MESS MENU =====");
        for(DayMenu day : weeklyMenu) {
            day.display();
        }
    }
    
    public void displayMenuWithRatings() {
        System.out.println("\n===== MESS MENU WITH RATINGS =====");
        for(DayMenu day : weeklyMenu) {
            day.displayWithRatings();
        }
    }
    
    public void rateMeal() {
        System.out.println("\n===== RATE A MEAL =====");
        
        System.out.println("Select day (1-7):");
        for(int i = 0; i < weeklyMenu.size(); i++) {
            System.out.println((i+1) + ". " + weeklyMenu.get(i).getDayName());
        }
        int dayChoice = scanner.nextInt() - 1;
        
        if(dayChoice < 0 || dayChoice >= weeklyMenu.size()) {
            System.out.println("Invalid day selection!");
            return;
        }
        
        DayMenu selectedDay = weeklyMenu.get(dayChoice);
        
        System.out.println("\nSelect meal:");
        System.out.println("1. Breakfast - " + selectedDay.getBreakfast().getName());
        System.out.println("2. Lunch - " + selectedDay.getLunch().getName());
        System.out.println("3. Snacks - " + selectedDay.getSnacks().getName());
        System.out.println("4. Dinner - " + selectedDay.getDinner().getName());
        
        int mealChoice = scanner.nextInt();
        MenuItem selectedMeal = null;
        
        switch(mealChoice) {
            case 1: selectedMeal = selectedDay.getBreakfast(); break;
            case 2: selectedMeal = selectedDay.getLunch(); break;
            case 3: selectedMeal = selectedDay.getSnacks(); break;
            case 4: selectedMeal = selectedDay.getDinner(); break;
            default: System.out.println("Invalid choice!"); return;
        }
        
        System.out.print("Enter rating (1-5 stars): ");
        int rating = scanner.nextInt();
        
        if(rating >= 1 && rating <= 5) {
            selectedMeal.addRating(rating);
            System.out.println("Thank you for rating " + selectedMeal.getName() + "!");
            saveData();
        } else {
            System.out.println("Invalid rating! Please enter 1-5.");
        }
    }
    
    public void showStatistics() {
        System.out.println("\n===== STATISTICS =====");
        System.out.printf("%-35s %-15s %-10s\n", "Dish Name", "Avg Rating", "Total Ratings");
        System.out.println("----------------------------------------------------------------");
        
        for(DayMenu day : weeklyMenu) {
            displayMenuItemStats(day.getBreakfast());
            displayMenuItemStats(day.getLunch());
            displayMenuItemStats(day.getSnacks());
            displayMenuItemStats(day.getDinner());
        }
    }
    
    public void showMostPopularDish() {
    System.out.println("\n===== MOST POPULAR DISH =====");
    
    MenuItem bestDish = null;
    double highestRating = 0;
    
    for(DayMenu day : weeklyMenu) {
        MenuItem[] meals = {day.getBreakfast(), day.getLunch(), 
                            day.getSnacks(), day.getDinner()};
        
        for(MenuItem meal : meals) {
            if(meal.getTotalRatings() > 0 && meal.getAverageRating() > highestRating) {
                highestRating = meal.getAverageRating();
                bestDish = meal;
            }
        }
    }
    
    if(bestDish != null) {
        System.out.println("🏆 " + bestDish.getName());
        System.out.println("⭐ Rating: " + String.format("%.1f", bestDish.getAverageRating()) + " stars");
        System.out.println("📊 Total ratings: " + bestDish.getTotalRatings());
    } else {
        System.out.println("No ratings yet! Be the first to rate a meal.");
    }
}
    private void displayMenuItemStats(MenuItem item) {
        if(item.getTotalRatings() > 0) {
            System.out.printf("%-35s %-15.1f %-10d\n", 
                            item.getName(), 
                            item.getAverageRating(), 
                            item.getTotalRatings());
        } else {
            System.out.printf("%-35s %-15s %-10d\n", 
                            item.getName(), 
                            "No ratings", 
                            0);
        }
    }
    
    public void adminUpdateMenu() {
        System.out.println("\n===== ADMIN: UPDATE MENU =====");
        System.out.print("Enter admin password: ");
        String password = scanner.next();
        
        if(!password.equals("admin123")) {
            System.out.println("Invalid password!");
            return;
        }
        
        System.out.println("Select day to update (1-7):");
        for(int i = 0; i < weeklyMenu.size(); i++) {
            System.out.println((i+1) + ". " + weeklyMenu.get(i).getDayName());
        }
        int dayChoice = scanner.nextInt() - 1;
        
        if(dayChoice < 0 || dayChoice >= weeklyMenu.size()) {
            System.out.println("Invalid day selection!");
            return;
        }
        
        DayMenu selectedDay = weeklyMenu.get(dayChoice);
        
        System.out.println("\nSelect meal to update:");
        System.out.println("1. Breakfast - Current: " + selectedDay.getBreakfast().getName());
        System.out.println("2. Lunch - Current: " + selectedDay.getLunch().getName());
        System.out.println("3. Snacks - Current: " + selectedDay.getSnacks().getName());
        System.out.println("4. Dinner - Current: " + selectedDay.getDinner().getName());
        
        int mealChoice = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter new item name: ");
        String newItem = scanner.nextLine();
        
        switch(mealChoice) {
            case 1: selectedDay.setBreakfast(newItem); break;
            case 2: selectedDay.setLunch(newItem); break;
            case 3: selectedDay.setSnacks(newItem); break;
            case 4: selectedDay.setDinner(newItem); break;
            default: System.out.println("Invalid choice!"); return;
        }
        
        System.out.println("Menu updated successfully!");
        saveData();
    }
    
    private void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            for(DayMenu day : weeklyMenu) {
                writer.println(day.getBreakfast().toFileString());
                writer.println(day.getLunch().toFileString());
                writer.println(day.getSnacks().toFileString());
                writer.println(day.getDinner().toFileString());
                writer.println("---");
            }
        } catch(IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
    
    private void loadData() {
        File file = new File(DATA_FILE);
        if(!file.exists()) {
            initializeDefaultMenu();
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            weeklyMenu.clear();
            String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", 
                            "Friday", "Saturday", "Sunday"};
            int dayIndex = 0;
            String line;
            List<MenuItem> currentDayMeals = new ArrayList<>();
            
            while((line = reader.readLine()) != null) {
                if(line.equals("---")) {
                    DayMenu dayMenu = new DayMenu(days[dayIndex]);
                    dayMenu.setBreakfast(currentDayMeals.get(0).getName());
                    dayMenu.setLunch(currentDayMeals.get(1).getName());
                    dayMenu.setSnacks(currentDayMeals.get(2).getName());
                    dayMenu.setDinner(currentDayMeals.get(3).getName());
                    weeklyMenu.add(dayMenu);
                    currentDayMeals.clear();
                    dayIndex++;
                } else {
                    String[] parts = line.split("\\|");
                    MenuItem item = new MenuItem(parts[0]);
                    currentDayMeals.add(item);
                }
            }
        } catch(IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
            initializeDefaultMenu();
        }
    }
}