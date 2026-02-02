// File: SS07/src/com/example/student/Main.java
package BTTH;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("SV001", "Nguyen Van A");
        Student s2 = new Student("SV002", "Le Thi B");
        Student s3 = new Student("SV003", "Tran Van C");

        s1.displayInfo();
        System.out.println("---");
        s2.displayInfo();
        System.out.println("---");
        s3.displayInfo();
        System.out.println("=== Static method call ===");
        Student.showTotalStudent();

        // Demonstrate difference: instance data (name/id) differ, static data is shared
        System.out.println("--- Access static via class ---");
        System.out.println("School (via class): " + Student.SCHOOL_NAME);
    }
}
