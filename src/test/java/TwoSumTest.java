import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumTest {

    @Test
    public void should_find_two_sum_if_exists() {

        // given
        final int[] input = new int[]{3, 1, 5, 7, 5, 9};

        // when
        final int[] result = TwoSum.findTwoSum(input, 10);

        Condition<int[]> containsAnyTwo = new Condition<>((int[] vals) ->
                Arrays.equals(vals, new int[]{0, 3})
                        || Arrays.equals(vals, new int[]{2, 4})
                        || Arrays.equals(vals, new int[]{1, 5}),
                "should contain any of pairs");

        // then
        assertThat(result).has(containsAnyTwo);
    }

    @Test
    public void should_not_find_two_sum_if_does_not_exist() {

        // given
        final int[] input = new int[]{3, 1, 5, 7, 5, 9};

        // when
        final int[] result = TwoSum.findTwoSum(input, 11);

        // then
        assertThat(result).isNull();
    }

    @Test
    public void should_find_two_sum_if_list_contains_duplicates() {

        // given
        final int[] input = new int[]{3, 3, 5, 7, 5, 7};

        // when
        final int[] result = TwoSum.findTwoSum(input, 11);

        // then
        assertThat(result).isNull();
    }
}
