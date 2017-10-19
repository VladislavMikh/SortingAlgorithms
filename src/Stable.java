import java.util.Arrays;
import java.util.Collections;

// Алгоритмы устойчивой сортировки
public class Stable {

    // метод для вывода рез-тов
    static void print(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    // Пузырьком 1, с флагом
    static void bubbleSort(int[] array) {
        boolean flag;
        int lastIndex = array.length;
        do {
            flag = false;
            for (int j = 0; j < lastIndex - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            lastIndex--;
        } while (flag == true);
    }

    // Вставками 2
    static void insertionSort(int[] array) {
        int i, j, newValue;
        for (i = 1; i < array.length; i++) {
            newValue = array[i];
            j = i;
            while (j > 0 && array[j - 1] > newValue) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = newValue;
        }
    }

    // Слиянием, рекурсивно 3
    static void mergeSort(int[] a, int lower, int higher) { // lower - позиция 1ого эл-та; higher - последнего.

        if (higher <= lower)
            return;
        int middle = lower + (higher - lower) / 2;
        mergeSort(a, lower, middle);
        mergeSort(a, middle + 1, higher);

        int[] temp = Arrays.copyOf(a, a.length);

        for (int k = lower; k <= higher; k++)
            temp[k] = a[k];

        int i = lower, j = middle + 1;
        for (int k = lower; k <= higher; k++) {

            if (i > middle) {
                a[k] = temp[j];
                j++;
            } else if (j > higher) {
                a[k] = temp[i];
                i++;
            } else if (temp[j] < temp[i]) {
                a[k] = temp[j];
                j++;
            } else {
                a[k] = temp[i];
                i++;
            }
        }
    }

    // Подсчетом 4
     static void countingSort(int[] array) {

        if (array.length == 0) return;
        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        int[] count = new int[max - min + 1];

        // подсчёт кол-ва вхождений эл-тов во входном массиве
         for (int i = 0; i < array.length; i++) {
             count[array[i] - min]++;
         }

         // перезаписываем значения исходного массива
         int arrayIndex = 0;
         for (int countIndex = 0; countIndex < count.length; countIndex++) {
            while (count[countIndex] > 0) {
                array[arrayIndex] = min + countIndex;
                arrayIndex++;
                count[countIndex]--;
            }
         }
    }
}

