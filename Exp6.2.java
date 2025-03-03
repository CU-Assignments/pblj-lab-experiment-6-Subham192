import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        
        
        students.add(new Student("Alice", 80));
        students.add(new Student("Bob", 72));
        students.add(new Student("Charlie", 90));
        students.add(new Student("David", 65));
        students.add(new Student("Eve", 85));

        
        System.out.println("Case 1: Normal Case");
        filterAndSortStudents(students);

        
        System.out.println("\nCase 2: All Below 75%");
        List<Student> studentsBelow75 = new ArrayList<>();
        studentsBelow75.add(new Student("Bob", 70));
        studentsBelow75.add(new Student("David", 60));
        studentsBelow75.add(new Student("Frank", 65));
        filterAndSortStudents(studentsBelow75);

        
        System.out.println("\nCase 3: Same Marks");
        List<Student> studentsSameMarks = new ArrayList<>();
        studentsSameMarks.add(new Student("Alice", 80));
        studentsSameMarks.add(new Student("Bob", 80));
        studentsSameMarks.add(new Student("Charlie", 85));
        filterAndSortStudents(studentsSameMarks);

        
        System.out.println("\nCase 4: Single Student Above 75%");
        List<Student> singleStudent = new ArrayList<>();
        singleStudent.add(new Student("Alice", 60));
        singleStudent.add(new Student("Bob", 50));
        singleStudent.add(new Student("Charlie", 90));
        filterAndSortStudents(singleStudent);
    }

    private static void filterAndSortStudents(List<Student> students) {
        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed()
                        .thenComparing(Student::getName))
                .toList();

        if (filteredStudents.isEmpty()) {
            System.out.println("No output (Empty List)");
        } else {
            filteredStudents.forEach(student -> System.out.print(student.getName() + " "));
            System.out.println(); 
        }
    }
}
