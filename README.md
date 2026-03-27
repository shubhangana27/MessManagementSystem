\# Mess Management System



A Java console application for managing hostel mess menu, collecting student ratings, and generating feedback.



**Features**



**Core Features**

\- ✅ View complete weekly menu (7 days, 4 meals per day)

\- ✅ Rate meals from 1-5 stars

\- ✅ View average ratings for all dishes

\- ✅ Persistent data storage using file I/O

\- ✅ Admin mode to update menu (password: admin123)



**Future Enhancements**

\- 🔄 Most popular dish of the week

\- 🔄 Search dishes by name

\- 🔄 Feedback comments with timestamps

\- 🔄 Export statistics to CSV



**Technologies Used**



\- Java 17

\- Collections Framework (ArrayList, List)

\- File I/O (BufferedReader, PrintWriter)

\- Exception Handling



**How to Run**



\### Prerequisites

\- Java JDK 11 or higher installed



\### Steps



1\. \*\*Clone the repository\*\*

&#x20;  ```bash

&#x20;  git clone https://github.com/shubhangana27/MessManagementSystem.git

&#x20;  cd MessManagementSystem
2. Compile the code

&#x20;  bash

&#x20;  javac -d . src/messsystem/\*.java

3\. Run the application

&#x20;  bash

&#x20;  java -cp src messsystem.Main



**How to Use**

Student Mode

1. View Menu - See all meals for the week

2\. Rate a Meal - Rate any meal from 1-5 stars

3\. View Statistics - See average ratings for all dishes



Admin Mode

1. Select "Admin - Update Menu" from main menu

2\. Enter password: admin123

3\. Choose day and meal to update

4\. Enter new dish name



**Sample Output**



===== MESS MANAGEMENT SYSTEM =====



===== MAIN MENU =====

1\. View Full Menu

2\. View Menu with Ratings

3\. Rate a Meal

4\. View Statistics

5\. Admin - Update Menu

6\. Exit



Choose option (1-6): 3



===== RATE A MEAL =====

Select day (1-7):

1\. Monday

2\. Tuesday

3\. Wednesday

4\. Thursday

5\. Friday

6\. Saturday

7\. Sunday

3



Select meal:

1\. Breakfast - Sandwich, Juice

2\. Lunch - Rajma Chawal

3\. Snacks - Dhokla

4\. Dinner - Aloo Gobhi, Roti

2

Enter rating (1-5 stars): 4

Thank you for rating Rajma Chawal!



===== MAIN MENU =====

1\. View Full Menu

2\. View Menu with Ratings

3\. Rate a Meal

4\. View Statistics

5\. Admin - Update Menu

6\. Exit



Choose option (1-6): 4



===== STATISTICS =====

Dish Name                           Avg Rating      Total Ratings

\----------------------------------------------------------------

Aloo Paratha, Curd                  No ratings      0

Dal Makhani, Jeera Rice, Roti       No ratings      0

Samosa, Chutney                     No ratings      0

Paneer Butter Masala, Naan          No ratings      0

Poha, Jalebi                        No ratings      0

Chole Bhature                       No ratings      0

Fruit, Biscuits                     No ratings      0

Veg Biryani, Raita                  No ratings      0

Sandwich, Juice                     No ratings      0

Rajma Chawal                        4.0             1

Dhokla                              No ratings      0

Aloo Gobhi, Roti                    No ratings      0

Upma, Sambar                        No ratings      0

Kadhi Pakora, Rice                  No ratings      0

Cutlet, Sauce                       No ratings      0

Dal Tadka, Tandoori Roti            No ratings      0

Paratha, Pickle                     No ratings      0

Veg Thali                           No ratings      0

Pakora, Chai                        No ratings      0

Shahi Paneer, Roti                  No ratings      0

Pancake, Syrup                      No ratings      0

Special Biryani                     No ratings      0

Ice Cream                           No ratings      0

Chinese Noodles, Manchurian         No ratings      0

Poori Bhaji                         No ratings      0

Buffet Special                      No ratings      0

Pizza                               No ratings      0

Roti, Dal, Sabzi                    No ratings      0





**Project Structure**



MessManagementSystem/

├── src/

│   └── messsystem/

│       ├── Main.java           # Entry point

│       ├── MessSystem.java     # Core logic

│       ├── DayMenu.java        # Day menu model

│       └── MenuItem.java       # Individual dish model

├── data/

│   └── mess\_data.txt           # Persistent storage

├── docs/                       # Project documentation

├── README.md

└── .gitignore



**Class Descriptions**

**Class**	        **Description**

Main.java	Entry point of the application. Displays menu and handles user input.

MessSystem.java	Core logic class. Manages menu, ratings, file operations, and admin functions.

DayMenu.java	Represents a single day with 4 meals (breakfast, lunch, snacks, dinner).

MenuItem.java	Represents an individual dish with name, ratings, and average calculation.



**Author**

Shubhangana Kanthed

GitHub: @shubhangana27





