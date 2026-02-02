import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise {

    // Hàm main: điểm bắt đầu chạy chương trình
    public static void main(String[] args) {

        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner sc = new Scanner(System.in);

        // Danh sách lưu các đối tượng Student
        List<Student> students = new ArrayList<>();

        // Biến điều khiển vòng lặp menu
        boolean running = true;

        // Vòng lặp menu chạy cho đến khi người dùng chọn Exit
        while (running) {

            // Hiển thị menu
            System.out.println("\n=== Student Management ===");
            System.out.println("School: " + Student.SCHOOL_NAME);
            System.out.println("1. Add new student");
            System.out.println("2. Show all students");
            System.out.println("3. Show average score");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            // Nhập lựa chọn từ người dùng
            String choice = sc.nextLine().trim();

            // Xử lý theo lựa chọn
            switch (choice) {

                // Chức năng 1: Thêm sinh viên mới
                case "1":
                    System.out.print("Full name: ");
                    String name = sc.nextLine().trim();

                    System.out.print("Class name: ");
                    String cls = sc.nextLine().trim();

                    // Gọi hàm nhập điểm có kiểm tra hợp lệ
                    double score = readScore(sc);

                    // Tạo đối tượng Student mới
                    Student s = new Student(name, score, cls);

                    // Thêm vào danh sách students
                    students.add(s);

                    // In ra ID của sinh viên vừa thêm
                    System.out.println("Added student with ID: " + s.getId());
                    break;

                // Chức năng 2: Hiển thị danh sách sinh viên
                case "2":
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        System.out.println("\n--- Student List ---");

                        // Duyệt từng sinh viên trong danh sách
                        for (Student st : students) {
                            System.out.printf(
                                    "ID: %d | Name: %s | Class: %s | Score: %.2f%n",
                                    st.getId(),
                                    st.getFullName(),
                                    st.getClassName(),
                                    st.getScore()
                            );
                        }
                    }
                    break;

                // Chức năng 3: Tính và hiển thị điểm trung bình
                case "3":
                    if (Student.getTotalStudents() == 0) {
                        System.out.println("No students to calculate average.");
                    } else {
                        System.out.printf(
                                "Average score of %d students: %.2f%n",
                                Student.getTotalStudents(),
                                Student.getAverageScore()
                        );
                    }
                    break;

                // Chức năng 0: Thoát chương trình
                case "0":
                    running = false;
                    break;

                // Trường hợp nhập sai lựa chọn
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        // Đóng Scanner
        sc.close();
        System.out.println("Exiting Student Management.");
    }

    // Hàm nhập điểm và kiểm tra hợp lệ (0 - 10)
    private static double readScore(Scanner sc) {
        while (true) {
            System.out.print("Score (0.0 - 10.0): ");
            String line = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(line);

                // Kiểm tra khoảng giá trị
                if (v < 0.0 || v > 10.0) {
                    System.out.println("Score must be between 0 and 10.");
                } else {
                    return v;
                }

            } catch (NumberFormatException e) {
                // Bắt lỗi nếu nhập không phải số
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}

// Lớp Student: dùng để mô tả đối tượng sinh viên
class Student {

    // Hằng số tên trường (static final)
    public static final String SCHOOL_NAME = "RikkeiEdu School";

    // Biến static dùng chung cho tất cả Student
    private static int nextId = 1;          // ID tự tăng
    private static int totalStudents = 0;   // Tổng số sinh viên
    private static double totalScore = 0.0; // Tổng điểm của tất cả sinh viên

    // Thuộc tính riêng của mỗi sinh viên
    private final int id;
    private String fullName;
    private double score;
    private String className;

    // Constructor: khởi tạo đối tượng Student
    public Student(String fullName, double score, String className) {
        this.id = nextId++; // gán ID tự tăng
        this.fullName = fullName;
        this.score = score;
        this.className = className;

        // Cập nhật thống kê chung
        totalStudents++;
        totalScore += score;
    }

    // Getter lấy ID
    public int getId() {
        return id;
    }

    // Getter lấy tên
    public String getFullName() {
        return fullName;
    }

    // Getter lấy điểm
    public double getScore() {
        return score;
    }

    // Getter lấy tên lớp
    public String getClassName() {
        return className;
    }

    // Lấy tổng số sinh viên
    public static int getTotalStudents() {
        return totalStudents;
    }

    // Tính điểm trung bình của tất cả sinh viên
    public static double getAverageScore() {
        return totalStudents == 0 ? 0.0 : totalScore / totalStudents;
    }
}
