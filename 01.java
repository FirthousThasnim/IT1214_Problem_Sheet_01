class Student {
    private int studentId;
    private String name;
    private int daysAttended;

    public Student(int studentId, String name, int daysAttended) {
        this.studentId = studentId;
        this.name = name;
        this.daysAttended = daysAttended;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysAttended() {
        return daysAttended;
    }

    public void setDaysAttended(int daysAttended) {
        this.daysAttended = daysAttended;
    }

    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Days Attended: " + daysAttended;
    }
}

class Classroom {
    private Student[] studentList;
    private int count;

    public Classroom() {
        studentList = new Student[10];
        count = 0;
    }

    public void addStudent(Student s) {
        if (count < studentList.length) {
            studentList[count++] = s;
        } else {
            System.out.println("Classroom is full.");
        }
    }

    public void updateAttendance(int studentId, int newDays) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (studentList[i].getStudentId() == studentId) {
                studentList[i].setDaysAttended(newDays);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void displayAllStudents() {
        for (int i = 0; i < count; i++) {
            System.out.println(studentList[i]);
        }
    }
}

 class StudentAttendanceSystem {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();

        classroom.addStudent(new Student(101, "Alice Smith", 12));
        classroom.addStudent(new Student(102, "Bob Jones", 15));
        classroom.addStudent(new Student(103, "Carol Lee", 10));

        classroom.updateAttendance(102, 16); // Update Bob's attendance
        classroom.updateAttendance(104, 14); // Non-existent student

        classroom.displayAllStudents();
    }
}
