import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Alice", 85),
                new Student("Bob", 78),
                new Student("Charlie", 95),
                new Student("Diana", 82)
        };

        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(students));

        MergeSortStudents.mergeSort(students, 0, students.length - 1);

        System.out.println("After sorting:");
        System.out.println(Arrays.toString(students));
    }
}