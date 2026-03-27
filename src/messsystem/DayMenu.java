package messsystem;

public class DayMenu {
    private String dayName;
    private MenuItem breakfast;
    private MenuItem lunch;
    private MenuItem snacks;
    private MenuItem dinner;
    
    public DayMenu(String dayName) {
        this.dayName = dayName;
        this.breakfast = new MenuItem(dayName + " - Breakfast");
        this.lunch = new MenuItem(dayName + " - Lunch");
        this.snacks = new MenuItem(dayName + " - Snacks");
        this.dinner = new MenuItem(dayName + " - Dinner");
    }
    
    public String getDayName() {
        return dayName;
    }
    
    public MenuItem getBreakfast() {
        return breakfast;
    }
    
    public MenuItem getLunch() {
        return lunch;
    }
    
    public MenuItem getSnacks() {
        return snacks;
    }
    
    public MenuItem getDinner() {
        return dinner;
    }
    
    public void setBreakfast(String itemName) {
        this.breakfast = new MenuItem(itemName);
    }
    
    public void setLunch(String itemName) {
        this.lunch = new MenuItem(itemName);
    }
    
    public void setSnacks(String itemName) {
        this.snacks = new MenuItem(itemName);
    }
    
    public void setDinner(String itemName) {
        this.dinner = new MenuItem(itemName);
    }
    
    public void display() {
        System.out.println("\n--- " + dayName + " ---");
        System.out.println("Breakfast: " + breakfast.getName());
        System.out.println("Lunch: " + lunch.getName());
        System.out.println("Snacks: " + snacks.getName());
        System.out.println("Dinner: " + dinner.getName());
    }
    
    public void displayWithRatings() {
        System.out.println("\n--- " + dayName + " ---");
        System.out.println("Breakfast: " + breakfast.toString());
        System.out.println("Lunch: " + lunch.toString());
        System.out.println("Snacks: " + snacks.toString());
        System.out.println("Dinner: " + dinner.toString());
    }
}