package Other;

// мусор, возможно, полезный
public class Temporary {
    static int[] countingSort(int[] array) {

        int[] result = new int[array.length];

        // нахождение min и max значений
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }

        // массив для хранения кол-ва раз, которое они встречаются в исходном массиве
        int[] counts = new int[max - min + 1];

        for (int i = 0; i < array.length; i++) {
            counts[array[i] - min]++;
        }

        counts[0]--;

        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            result[counts[array[i] - min]--] = array[i];
        }

        return result;
    }

    static void sort(int[] array) {

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

        int range = max - min + 1;
        int[] count = new int[range];

        // подсчёт кол-ва вхождений эл-тов во входном массиве
        for (int i = 0; i < array.length; i++)
            count[array[i] - min]++;

        // подсчет суммы индексов
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // изменение входного массива
        int j = 0;
        for (int i = 0; i < range; i++) {
            while (j < count[i]) {
                array[j++] = i + min;
            }
        }
    }

}
