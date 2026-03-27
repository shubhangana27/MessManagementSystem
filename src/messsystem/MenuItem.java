package messsystem;

public class MenuItem {
    private String name;
    private double averageRating;
    private int totalRatings;
    private int ratingSum;
    
    public MenuItem(String name) {
        this.name = name;
        this.averageRating = 0.0;
        this.totalRatings = 0;
        this.ratingSum = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public void addRating(int rating) {
        if(rating >= 1 && rating <= 5) {
            ratingSum += rating;
            totalRatings++;
            averageRating = (double) ratingSum / totalRatings;
        }
    }
    
    public double getAverageRating() {
        return averageRating;
    }
    
    public int getTotalRatings() {
        return totalRatings;
    }
    
    @Override
    public String toString() {
        if(totalRatings == 0) {
            return name + " - No ratings yet";
        }
        return String.format("%s - %.1f stars (%d ratings)", 
                            name, averageRating, totalRatings);
    }
    
    public String toFileString() {
        return name + "|" + ratingSum + "|" + totalRatings;
    }
}