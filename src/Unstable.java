import java.util.Arrays;

// Алгоритмы неустойчивой сортировки
public class Unstable {

    // метод для вывода рез-тов
    static void print(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    // Кучей / пирамидальная МОЖНО ПРОЩЕ, КАЖЕТСЯ
    static void heapSort(int[] array) {

        // Построение дерева
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);

            // Извлечение элемента из кучи
            for (int j = n - 1; j >= 0; j--) {
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;

                // Построить новое дерево (без извлеченного эл-та)
                heapify(array, j, 0);
            }
        }
    }

    // вспомогательная для пирамидальной сортировки
    static void heapify(int[] array, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) largest = left;
        if (right < n && array[right] > array[largest]) largest = right;
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heapify(array, n, largest);
        }
    }

    //static void quickSort(int)

}
