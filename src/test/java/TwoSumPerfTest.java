import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumPerfTest {

    static int[] input;

    @BeforeClass
    public static void setUp() {
        input = generateLargeInput();
    }

    @Test(timeout = 10000)
    @Ignore("too slow to run automatically")
    public void simple_should_find_two_sum_if_exists_performance() {

        final int expectedSum = 999555;

        // when
        LocalTime start = LocalTime.now();
        final int[] result = TwoSum.simpleFindTwoSum(input, expectedSum);
        LocalTime end = LocalTime.now();

        System.out.printf("Simple %s - Duration: %s\n", Arrays.toString(result),  Duration.between(start, end));

        assertThat(result).isNotNull();
        assertThat(result[0] + result[1]).isEqualTo(expectedSum);
    }

    @Test(timeout = 10000)
    public void hashmap_should_find_two_sum_if_exists_performance() {

        final int expectedSum = 999555;

        // when
        LocalTime start = LocalTime.now();
        final int[] result = TwoSum.hashMapFindTwoSum(input, expectedSum);
        LocalTime end = LocalTime.now();

        System.out.printf("HashMap %s - Duration: %s\n", Arrays.toString(result),  Duration.between(start, end));

        assertThat(result).isNotNull();
        assertThat(result[0] + result[1]).isEqualTo(expectedSum);
    }

    static int[] generateLargeInput() {

        int[] result = new int[10000000];
        for (int i=0; i < result.length; ++i) {
            result[i] = i % 555777;
        }
        return result;
    }
}
