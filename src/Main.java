import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        // Тест для пузырька
        int[] mas1 = {7, -4, 0, 5, 1, 2};
        System.out.print(" + Пузырьком: " + Arrays.toString(mas1) + " --> ");
        Stable.bubbleSort(mas1);
        Stable.print(mas1);

        // Вставками
        int[] mas2 = {9, -5, 8, 7, 1, 4, 3};
        System.out.print(" + Вставками: " + Arrays.toString(mas2) + " --> ");
        Stable.insertionSort(mas2);
        //System.out.print(" + Вставками: ");
        Stable.print(mas2);

        // Слиянием
        int[] mas3 = {2, 6, 4, 0, 9, 3, 7, 1};
        System.out.print(" + Слиянием: " + Arrays.toString(mas3) + " --> ");
        Stable.mergeSort(mas3, 0, mas1.length - 1);
        Stable.print(mas3);

        // Подсчётом
        int[] mas4 = {7, 3, 5, 5, 0, 2, 8, 5, 1 ,0};
        System.out.print("   Подсчётом: " + Arrays.toString(mas4) + " --> ");
        Stable.countingSort(mas4);
        System.out.println(Arrays.toString(mas4));
        //System.out.println(Arrays.toString(Stable.sort(mas4)));

        // Кучей
        int[] mas5 = {11, 10, 14, 6, 2, 8};
        //int n = array.lenght;
        System.out.print("Кучей НЕ ДОДЕЛАНО: ");
        Unstable.print(mas5);

        // Быстрая
        System.out.println("Быструю СДЕЛАТЬ");

    }
}
