import java.util.HashMap;
import java.util.Map;

/**
 * Write a function that, when passed a list and a target sum, returns two distinct zero-based indices of any two of the numbers, whose sum is equal to the target sum. If there are no two numbers, the function should return null.
 * <p>
 * For example, findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10) should return a single dimensional array with two elements and contain any of the following pairs of indices:
 * <p>
 * 0 and 3 (or 3 and 0) as 3 + 7 = 10
 * 1 and 5 (or 5 and 1) as 1 + 9 = 10
 * 2 and 4 (or 4 and 2) as 5 + 5 = 10
 */
public class TwoSum {

    public static int[] findTwoSum(int[] list, int sum) {
        return simpleFindTwoSum(list, sum);
    }

    public static int[] simpleFindTwoSum(int[] list, int sum) {

        for (int i = 0; i < list.length; ++i) {

            for (int j = i + 1; j < list.length; ++j) {

                if (list[i] + list[j] == sum) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] hashMapFindTwoSum(int[] list, int sum) {

        Map<Integer, Integer> resultCandidates = new HashMap<>();
        for (int i = 0; i < list.length; ++i) {

            if (list[i] > sum) {
                continue;
            }

            Integer firstDigitIndex = resultCandidates.get(list[i]);
            if (firstDigitIndex != null) {
                return new int[]{firstDigitIndex, i};
            }

            int secondDigit = sum - list[i];
            resultCandidates.put(secondDigit, i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[]{3, 1, 5, 7, 5, 9}, 10);
        if (indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
