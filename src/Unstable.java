import java.util.Arrays;

// Алгоритмы неустойчивой сортировки
public class Unstable {

    // метод для вывода рез-тов
    static void print(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    // Пирамидальная (кучей)
    public static void heapSort(int[] array) {

        int arrayLength = array.length;

        // Построение дерева
        for (int index = arrayLength / 2 - 1; index >= 0; index--) {
            heapify(array, index, arrayLength);
        }

        // Извлечение эл-та из кучи
        for (int index = arrayLength - 1; index > 0; index--) {
            int temp = array[index];
            array[index] = array[0];
            array[0] = temp;
            heapify(array, 0, index); // перерисовка дерева (без извлеченного эл-та)
        }
    }

    private static void heapify(int[] array, int start, int arrayLength) {

        int indexOfMax = start;
        int left = 2 * start + 1;
        int right = left + 1;
        if (left < arrayLength && array[left] > array[indexOfMax]) {
            indexOfMax = left;
        }
        if (right < arrayLength && array[right] > array[indexOfMax]) {
            indexOfMax = right;
        }
        if (indexOfMax != start) {
            int temp = array[indexOfMax];
            array[indexOfMax] = array[start];
            array[start] = temp;
            heapify(array, indexOfMax, arrayLength);
        }
    }

    // Быcтрая (Хоара)
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int min, int max) {
        int left = min;
        int right = max;
        int key = array[(min + max) / 2];
        while (left <= right) {
            while (array[left] < key) {
                left++;
            }
            while (array[right] > key) {
                right--;
            }
            if (left <= right) {
                int temporary = array[left];
                array[left] = array[right];
                array[right] = temporary;
                right--;
                left++;
            }
        }
        if (min < right) {
            quickSort(array, min, right);
            quickSort(array, right + 1, max);
        }
    }
}