import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputTest {

    @Test
    public void should_concat_characters_if_text_input() {

        UserInput.TextInput input = new UserInput.TextInput();
        input.add('1');
        input.add('a');
        input.add('0');

        final String result = input.getValue();

        assertThat(result).isEqualTo("1a0");
    }

    @Test
    public void should_concat_only_digits_if_numeric_input() {

        UserInput.TextInput input = new UserInput.NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');

        final String result = input.getValue();

        assertThat(result).isEqualTo("10");
    }

}
