import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "X", 10);
        Student student2 = new Student(2, "y", 20);
        Student student3 = new Student(3, "w", 30);

        List<Student> students = Arrays.asList(student1, student2, student3);

        Management management = new StudentManagement();

        management.displayStudents(students, System.out::println);

        management.displayStudentsByFilter(students, student -> student.getAge() > 21, System.out::println);


        Student newStudent = management.createStudent(() -> new Student(4, "Eva", 23));
        System.out.println("\nNewly created student: " + newStudent);


        List<Student> sortedStudents = management.sortStudentsById(students, Comparator.comparingInt(Student::getId));
        System.out.println("\nSorted by ID:");
        management.displayStudents(sortedStudents, System.out::println);

        System.out.println("\nConverting students to a stream and displaying:");
        management.convertToStream(students).forEach(System.out::println);

    }
}