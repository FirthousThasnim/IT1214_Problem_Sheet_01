// Student.java
class Student {
    private String name;
    private int exam1, exam2, exam3;

    // Constructor with input validation
    public Student(String name, int exam1, int exam2, int exam3) {
        if (exam1 < 0 || exam1 > 100 || exam2 < 0 || exam2 > 100 || exam3 < 0 || exam3 > 100) {
            throw new IllegalArgumentException("Exam scores must be between 0 and 100.");
        }
        this.name = name;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.exam3 = exam3;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Method to calculate average score
    public double calculateAverage() {
        return (exam1 + exam2 + exam3) / 3.0;
    }
}

// GradeCalculator.java
class GradeCalculator {
    public static void main(String[] args) {
        try {
            // Creating Student object (one invalid score = 110)
            Student s = new Student("John", 75, 110, 90);
            // If no exception, print name and average
            System.out.printf("Name: %s, Average: %.2f%n", s.getName(), s.calculateAverage());
        } catch (IllegalArgumentException e) {
            // Exception handling
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
