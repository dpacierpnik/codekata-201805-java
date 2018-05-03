/**
 * Implement function countNumbers that accepts a sorted array of integers and counts the number of array elements
 * that are less than the parameter lessThan.
 * <p>
 * For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 because there are two array elements less than 4.
 */
public class SortedSearch {

    public static int countNumbers(int[] sortedArray, int lessThan) {

        if (sortedArray[sortedArray.length - 1] < lessThan) {
            return sortedArray.length;
        }
        if (sortedArray[0] >= lessThan) {
            return 0;
        }

        int lastLessThenIndex = -1;
        int lastGreaterThenIndex = sortedArray.length;

        int rangeLength = (sortedArray.length / 2);

        int actualIndex = rangeLength;

        while (rangeLength > 0) {

            if (sortedArray[actualIndex] < lessThan) {
                lastLessThenIndex = actualIndex;
                // search next to the right
                rangeLength = (lastGreaterThenIndex - actualIndex) / 2;
            } else {
                lastGreaterThenIndex = actualIndex;
                // search next to the left
                rangeLength = (actualIndex - lastLessThenIndex) / 2;
            }

            actualIndex = lastLessThenIndex + rangeLength;
        }

        return lastLessThenIndex + 1;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[]{1, 3, 5, 7}, 4));
    }
}