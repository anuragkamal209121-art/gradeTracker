import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    Scanner sc = new Scanner(System.in);

    ArrayList<student> students = new ArrayList<>();


    // Constructor
    public GradeTracker() {

        StudentFileManager.loadStudents(students);
    }


    // Main Menu
    public void start() {

        int choice;

        do {

            System.out.println();
            System.out.println("================================");
            System.out.println("          GRADE TRACKER");
            System.out.println("================================");

            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Calculate Result");
            System.out.println("4. View All Students");
            System.out.println("5. Average Score");
            System.out.println("6. Highest Score");
            System.out.println("7. Lowest Score");
            System.out.println("8. Update Student Marks");
            System.out.println("9. Delete Student");
            System.out.println("10. Search Student");
            System.out.println("11. Sort Students by Percentage");
            System.out.println("12. Exit");

            System.out.print("Enter your choice: ");

            choice = getIntegerInput();


            if (choice == 1) {

                addStudent();

            }
            else if (choice == 2) {

                viewStudent();

            }
            else if (choice == 3) {

                calculateResult();

            }
            else if (choice == 4) {

                viewAllStudents();

            }
            else if (choice == 5) {

                averageScore();

            }
            else if (choice == 6) {

                highestScore();

            }
            else if (choice == 7) {

                lowestScore();

            }
            else if (choice == 8) {

                updateStudent();

            }
            else if (choice == 9) {

                deleteStudent();

            }
            else if (choice == 10) {

                searchStudent();

            }
            else if (choice == 11) {

                sortStudents();

            }
            else if (choice == 12) {

                System.out.println();
                System.out.println(
                        "Thank you for using Grade Tracker."
                );

            }
            else {

                System.out.println(
                        "Invalid choice. Please enter 1 to 12."
                );
            }

        } while (choice != 12);
    }


    // Integer Input Validation
    public int getIntegerInput() {

        while (!sc.hasNextInt()) {

            System.out.println(
                    "Invalid input. Please enter a number."
            );

            sc.next();

            System.out.print("Enter again: ");
        }

        return sc.nextInt();
    }


    // Add Student
    public void addStudent() {

        System.out.println();
        System.out.println("===== ADD STUDENT =====");


        // Student ID
        System.out.print("Enter Student ID: ");

        int id = getIntegerInput();


        if (id <= 0) {

            System.out.println(
                    "Student ID must be greater than 0."
            );

            return;
        }


        // Duplicate ID Check
        for (int i = 0; i < students.size(); i++) {

            student s = students.get(i);

            if (s.id == id) {

                System.out.println(
                        "Student ID already exists."
                );

                return;
            }
        }


        // Student Name
        sc.nextLine();

        String name;

        while (true) {

            System.out.print("Enter Student Name: ");

            name = sc.nextLine().trim();


            if (name.length() == 0) {

                System.out.println(
                        "Name cannot be empty."
                );

            }
            else {

                break;
            }
        }


        student s = new student(id, name);


        // Marks
        System.out.print("Enter Java Marks (0-100): ");
        s.javaMarks = getValidMarks();


        System.out.print("Enter DBMS Marks (0-100): ");
        s.dbmsMarks = getValidMarks();


        System.out.print("Enter DSA Marks (0-100): ");
        s.dsaMarks = getValidMarks();


        System.out.print("Enter OS Marks (0-100): ");
        s.osMarks = getValidMarks();


        System.out.print("Enter CN Marks (0-100): ");
        s.cnMarks = getValidMarks();


        students.add(s);

        StudentFileManager.saveStudents(students);


        System.out.println();
        System.out.println(
                "Student added successfully!"
        );
    }


    // Marks Validation
    public int getValidMarks() {

        int marks = getIntegerInput();


        while (marks < 0 || marks > 100) {

            System.out.println(
                    "Invalid marks. Marks must be between 0 and 100."
            );

            System.out.print("Enter marks again: ");

            marks = getIntegerInput();
        }


        return marks;
    }


    // View Student
    public void viewStudent() {

        System.out.println();
        System.out.println("===== VIEW STUDENT =====");

        System.out.print("Enter Student ID: ");

        int id = getIntegerInput();


        for (int i = 0; i < students.size(); i++) {

            student s = students.get(i);


            if (s.id == id) {

                System.out.println();

                System.out.println(
                        "Student ID: " + s.id
                );

                System.out.println(
                        "Student Name: " + s.name
                );

                System.out.println(
                        "Java: " + s.javaMarks
                );

                System.out.println(
                        "DBMS: " + s.dbmsMarks
                );

                System.out.println(
                        "DSA: " + s.dsaMarks
                );

                System.out.println(
                        "OS: " + s.osMarks
                );

                System.out.println(
                        "CN: " + s.cnMarks
                );

                return;
            }
        }


        System.out.println(
                "Student not found."
        );
    }


    // Calculate Result
    public void calculateResult() {

        System.out.println();
        System.out.println(
                "===== CALCULATE RESULT ====="
        );

        System.out.print("Enter Student ID: ");

        int id = getIntegerInput();


        for (int i = 0; i < students.size(); i++) {

            student s = students.get(i);


            if (s.id == id) {

                int total =
                        GradeCalculator.calculateTotal(s);


                double percentage =
                        GradeCalculator.calculatePercentage(s);


                String grade =
                        GradeCalculator.calculateGrade(
                                percentage
                        );


                System.out.println();

                System.out.println(
                        "Student Name: " + s.name
                );

                System.out.println(
                        "Total: " + total + "/500"
                );

                System.out.println(
                        "Percentage: " + percentage + "%"
                );

                System.out.println(
                        "Grade: " + grade
                );

                return;
            }
        }


        System.out.println(
                "Student not found."
        );
    }


    // View All Students
    public void viewAllStudents() {

        if (students.size() == 0) {

            System.out.println(
                    "No students found."
            );

            return;
        }


        System.out.println();

        System.out.println(
                "========== SUMMARY REPORT =========="
        );

        System.out.println(
                "ID\tName\tPercentage\tGrade"
        );


        for (int i = 0; i < students.size(); i++) {

            student s = students.get(i);


            double percentage =
                    GradeCalculator.calculatePercentage(s);


            String grade =
                    GradeCalculator.calculateGrade(
                            percentage
                    );


            System.out.println(
                    s.id + "\t" +
                    s.name + "\t" +
                    percentage + "%\t\t" +
                    grade
            );
        }
    }


    // Average Score
    public void averageScore() {

        if (students.size() == 0) {

            System.out.println(
                    "No students found."
            );

            return;
        }


        double sum = 0;


        for (int i = 0; i < students.size(); i++) {

            student s = students.get(i);


            double percentage =
                    GradeCalculator.calculatePercentage(s);


            sum = sum + percentage;
        }


        double averageOfAllStudents =
                sum / students.size();


        System.out.println();

        System.out.println(
                "Average Score of All Students: "
                        + averageOfAllStudents + "%"
        );
    }


    // Highest Score
    public void highestScore() {

        if (students.size() == 0) {

            System.out.println(
                    "No students found."
            );

            return;
        }


        student highest =
                students.get(0);


        double highestPercentage =
                GradeCalculator.calculatePercentage(
                        highest
                );


        for (int i = 1; i < students.size(); i++) {

            student s =
                    students.get(i);


            double percentage =
                    GradeCalculator.calculatePercentage(s);


            if (percentage > highestPercentage) {

                highest = s;

                highestPercentage = percentage;
            }
        }


        System.out.println();

        System.out.println(
                "===== HIGHEST SCORE ====="
        );

        System.out.println(
                "ID: " + highest.id
        );

        System.out.println(
                "Name: " + highest.name
        );

        System.out.println(
                "Percentage: " +
                highestPercentage + "%"
        );
    }


    // Lowest Score
    public void lowestScore() {

        if (students.size() == 0) {

            System.out.println(
                    "No students found."
            );

            return;
        }


        student lowest =
                students.get(0);


        double lowestPercentage =
                GradeCalculator.calculatePercentage(
                        lowest
                );


        for (int i = 1; i < students.size(); i++) {

            student s =
                    students.get(i);


            double percentage =
                    GradeCalculator.calculatePercentage(s);


            if (percentage < lowestPercentage) {

                lowest = s;

                lowestPercentage = percentage;
            }
        }


        System.out.println();

        System.out.println(
                "===== LOWEST SCORE ====="
        );

        System.out.println(
                "ID: " + lowest.id
        );

        System.out.println(
                "Name: " + lowest.name
        );

        System.out.println(
                "Percentage: " +
                lowestPercentage + "%"
        );
    }


    // Update Student
    public void updateStudent() {

        System.out.println();

        System.out.println(
                "===== UPDATE STUDENT ====="
        );


        System.out.print(
                "Enter Student ID: "
        );

        int id = getIntegerInput();


        for (int i = 0; i < students.size(); i++) {

            student s =
                    students.get(i);


            if (s.id == id) {

                System.out.println(
                        "Student found: " + s.name
                );


                System.out.print(
                        "Enter new Java Marks (0-100): "
                );

                s.javaMarks =
                        getValidMarks();


                System.out.print(
                        "Enter new DBMS Marks (0-100): "
                );

                s.dbmsMarks =
                        getValidMarks();


                System.out.print(
                        "Enter new DSA Marks (0-100): "
                );

                s.dsaMarks =
                        getValidMarks();


                System.out.print(
                        "Enter new OS Marks (0-100): "
                );

                s.osMarks =
                        getValidMarks();


                System.out.print(
                        "Enter new CN Marks (0-100): "
                );

                s.cnMarks =
                        getValidMarks();


                StudentFileManager.saveStudents(
                        students
                );


                System.out.println();

                System.out.println(
                        "Student marks updated successfully!"
                );

                return;
            }
        }


        System.out.println(
                "Student not found."
        );
    }


    // Delete Student
    public void deleteStudent() {

        System.out.println();

        System.out.println(
                "===== DELETE STUDENT ====="
        );


        System.out.print(
                "Enter Student ID: "
        );

        int id = getIntegerInput();


        for (int i = 0; i < students.size(); i++) {

            student s =
                    students.get(i);


            if (s.id == id) {

                students.remove(i);


                StudentFileManager.saveStudents(
                        students
                );


                System.out.println(
                        "Student deleted successfully!"
                );

                return;
            }
        }


        System.out.println(
                "Student not found."
        );
    }


    // Search Student
    public void searchStudent() {

        System.out.println();

        System.out.println(
                "===== SEARCH STUDENT ====="
        );


        sc.nextLine();


        System.out.print(
                "Enter Student Name: "
        );

        String searchName =
                sc.nextLine().trim();


        if (searchName.length() == 0) {

            System.out.println(
                    "Search name cannot be empty."
            );

            return;
        }


        boolean found = false;


        for (int i = 0; i < students.size(); i++) {

            student s =
                    students.get(i);


            if (s.name.equalsIgnoreCase(
                    searchName
            )) {

                double percentage =
                        GradeCalculator.calculatePercentage(s);


                String grade =
                        GradeCalculator.calculateGrade(
                                percentage
                        );


                System.out.println();

                System.out.println(
                        "Student ID: " + s.id
                );

                System.out.println(
                        "Name: " + s.name
                );

                System.out.println(
                        "Percentage: " +
                        percentage + "%"
                );

                System.out.println(
                        "Grade: " + grade
                );


                found = true;
            }
        }


        if (!found) {

            System.out.println(
                    "Student not found."
            );
        }
    }


    // Sort Students by Percentage
    public void sortStudents() {

        if (students.size() == 0) {

            System.out.println(
                    "No students found."
            );

            return;
        }


        // Bubble Sort
        for (int i = 0;
             i < students.size() - 1;
             i++) {

            for (int j = 0;
                 j < students.size() - 1 - i;
                 j++) {


                student s1 =
                        students.get(j);


                student s2 =
                        students.get(j + 1);


                double percentage1 =
                        GradeCalculator.calculatePercentage(s1);


                double percentage2 =
                        GradeCalculator.calculatePercentage(s2);


                if (percentage1 < percentage2) {

                    students.set(j, s2);

                    students.set(j + 1, s1);
                }
            }
        }


        StudentFileManager.saveStudents(
                students
        );


        System.out.println();

        System.out.println(
                "Students sorted by percentage successfully!"
        );


        System.out.println();

        System.out.println(
                "===== SORTED STUDENTS ====="
        );


        for (int i = 0;
             i < students.size();
             i++) {

            student s =
                    students.get(i);


            double percentage =
                    GradeCalculator.calculatePercentage(s);


            String grade =
                    GradeCalculator.calculateGrade(
                            percentage
                    );


            System.out.println(
                    (i + 1) + ". " +
                    s.name +
                    " - " +
                    percentage +
                    "% - Grade " +
                    grade
            );
        }
    }
}