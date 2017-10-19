package Other
public class Temp {
    // подсчётом на котлете
    fun countingSort(array: Array<Int>) {
        val min = array.min()!!
        val countArray = Array(array.max()!! - min + 1, { 0 })
        for (element in array) {
            countArray[element - min]++
        }
        var i = 0
        for (index in 0..countArray.lastIndex) {
            while (countArray[index] > 0) {
                array[i] = min + index
                i++
                countArray[index]--
            }
        }
    }
}