import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortedSearchTest {

    @Test
    public void should_find_result_in_even_array() {

        int[] input = new int[]{1, 3, 5, 7};
        int lessThen = 4;

        int count = SortedSearch.countNumbers(input, lessThen);

        assertThat(count).isEqualTo(2);
    }

    @Test
    public void should_find_result_in_odd_array() {

        int[] input = new int[]{1, 2, 3, 5, 7};
        int lessThen = 4;

        int count = SortedSearch.countNumbers(input, lessThen);

        assertThat(count).isEqualTo(3);
    }

    @Test
    public void should_find_result_when_all_less_then() {

        int[] input = new int[]{1, 2, 3, 5, 7};
        int lessThen = 9;

        int count = SortedSearch.countNumbers(input, lessThen);

        assertThat(count).isEqualTo(input.length);
    }

    @Test
    public void should__not_find_result_when_all_greater_then() {

        int[] input = new int[]{2, 3, 4, 5, 7};
        int lessThen = 1;

        int count = SortedSearch.countNumbers(input, lessThen);

        assertThat(count).isEqualTo(0);
    }
}
