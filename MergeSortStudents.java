public class MergeSortStudents {
    private static Student[] temp;

    public static void mergeSort(Student[] students, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            // Initialize the temp array only once for the entire sort process
            if (temp == null) {
                temp = new Student[students.length];
            }

            int middleIndex = (leftIndex + rightIndex) / 2;

            // Sort first and second halves
            mergeSort(students, leftIndex, middleIndex);
            mergeSort(students, middleIndex + 1, rightIndex);

            // Merge the sorted halves
            merge(students, leftIndex, middleIndex, rightIndex);
        }
    }

    private static void merge(Student[] students, int leftIndex, int middleIndex, int rightIndex) {
        int leftPointer = leftIndex;       // Pointer for the left subarray
        int rightPointer = middleIndex + 1; // Pointer for the right subarray
        int mergedPointer = leftIndex;     // Pointer for the merged array

        // Copy data to temp arrays for merging
        for (int index = leftIndex; index <= rightIndex; index++) {
            temp[index] = students[index];
        }

        // Merge the two halves into the main array
        while (leftPointer <= middleIndex && rightPointer <= rightIndex) {
            if (temp[leftPointer].score >= temp[rightPointer].score) {
                students[mergedPointer] = temp[leftPointer];
                leftPointer++;  // Move the leftPointer to the next element in the left subarray
            } else {
                students[mergedPointer] = temp[rightPointer];
                rightPointer++; // Move the rightPointer to the next element in the right subarray
            }
            mergedPointer++; // Move to the next position in the merged array
        }

        // Copy the remaining elements of the left subarray, if any
        while (leftPointer <= middleIndex) {
            students[mergedPointer] = temp[leftPointer];
            leftPointer++;
            mergedPointer++;
        }

        // No need to copy the right subarray, as its elements are already in place
    }
}