public class MergeSortStudents {
    private static Student[] temp;

    public static void mergeSort(Student[] students, int left, int right) {
        if (left < right) {
            // Initialize the temp array only once for the entire sort process
            if (temp == null) {
                temp = new Student[students.length];
            }

            int mid = (left + right) / 2;

            // Sort first and second halves
            mergeSort(students, left, mid);
            mergeSort(students, mid + 1, right);

            // Merge the sorted halves
            merge(students, left, mid, right);
        }
    }

    public static void merge(Student[] students, int left,int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        // Copy data to temp arrays for merging
        for (int index = left; index <= right; index++) {
            temp[index] = students[index];
        }

        // Merge the two halves into the main array
        while (i <= mid && j <= right) {
            if (temp[i].score >= temp[j].score) {
                students[k] = temp[i];
                i++;
            } else {
                students[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of the left half, if any
        while (i <= mid) {
            students[k] = temp[i];
            i++;
            k++;
        }

        // No need to copy the right half, since it's already in the correct place
    }

}
