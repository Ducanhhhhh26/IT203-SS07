// File: SS07/src/com/example/student/Student.java
package BTTH;
public class Student {
    private String id;
    private String name;

    public static int studentCount = 0;
    public static final String SCHOOL_NAME = "ABC University";

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        studentCount++;
    }

    public void displayInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name      : " + name);
        System.out.println("School    : " + SCHOOL_NAME);
    }

    public static void showTotalStudent() {
        System.out.println("Total students: " + studentCount);
        System.out.println("School        : " + SCHOOL_NAME);
    }
}
