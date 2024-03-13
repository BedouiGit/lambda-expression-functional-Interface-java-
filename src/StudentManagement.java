import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StudentManagement implements Management {
    @Override
    public void displayStudents(List<Student> students, Consumer<Student> con) {
        for (Student student : students) {
            con.accept(student);
        }
    }

    @Override
    public void displayStudentsByFilter(List<Student> students, Predicate<Student> pre, Consumer<Student> con) {
        students.stream().filter(pre).forEach(con);
    }

    @Override
    public String returnStudentsNames(List<Student> students, Function<Student, String> fun) {
        StringBuilder names = new StringBuilder();
        students.forEach(student -> names.append(fun.apply(student)).append(" "));
        return names.toString().trim();
    }

    @Override
    public Student createStudent(Supplier<Student> sup) {
        return sup.get();
    }

    @Override
    public List<Student> sortStudentsById(List<Student> students, Comparator<Student> com) {
        List<Student> sortedList = new ArrayList<>(students);
        sortedList.sort(com);
        return sortedList;
    }

    @Override
    public Stream<Student> convertToStream(List<Student> students) {
        return students.stream();
    }

}
