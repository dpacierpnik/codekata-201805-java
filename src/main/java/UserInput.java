/**
 * User interface contains two types of user input controls: TextInput, which accepts all characters and NumericInput,
 * which accepts only digits.
 * <p>
 * Implement the class TextInput that contains:
 * <p>
 * Public method void add(char c) - adds the given character to the current value
 * Public method String getValue() - returns the current value
 * <p>
 * Implement the class NumericInput that:
 * <p>
 * Inherits from TextInput
 * Overrides the add method so that each non-numeric character is ignored
 * <p>
 * For example, the following code should output "10":
 * <p>
 * TextInput input = new NumericInput();
 * input.add('1');
 * input.add('a');
 * input.add('0');
 * System.out.println(input.getValue());
 */
public class UserInput {

    public static class TextInput {

        private String value = "";

        public void add(char c) {
            value += c;
        }

        public String getValue() {
            return value;
        }
    }

    public static class NumericInput extends TextInput {

        public void add(char c) {
            if (Character.isDigit(c)) {
                super.add(c);
            }
        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}