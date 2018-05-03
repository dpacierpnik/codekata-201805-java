import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeTest {

    @Test
    public void should_return_true_if_palindrome_with_odd_length() {

        final String input = "Deleveled";

        final boolean result = Palindrome.isPalindrome(input);

        assertThat(result).isTrue();
    }

    @Test
    public void should_return_true_if_palindrome_with_even_length() {

        final String input = "Deleeled";

        final boolean result = Palindrome.isPalindrome(input);

        assertThat(result).isTrue();
    }

    @Test
    public void should_return_false_if_not_palindrome() {

        final String input = "Deleleved";

        final boolean result = Palindrome.isPalindrome(input);

        assertThat(result).isFalse();
    }
}
