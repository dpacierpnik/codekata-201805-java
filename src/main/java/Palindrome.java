/**
 * A palindrome is a word that reads the same backward or forward.
 * <p>
 * Write a function that checks if a given word is a palindrome. Character case should be ignored.
 * <p>
 * For example, isPalindrome("Deleveled") should return true as character case should be ignored, resulting in "deleveled",
 * which is a palindrome since it reads the same backward and forward.
 */
public class Palindrome {

    public static boolean isPalindrome(String word) {

        String loweredWord = word.toLowerCase();

        char[] wordChars = loweredWord.toCharArray();

        int wordHalfLength = (int) (wordChars.length / 2);

        for (int i = 0; i < wordHalfLength; ++i) {

            if (wordChars[i] != wordChars[wordChars.length - i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}