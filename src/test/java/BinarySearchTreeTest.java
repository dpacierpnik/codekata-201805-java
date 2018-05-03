import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTreeTest {

    @Test
    public void should_return_true_if_contains_greater_value() {

        // given
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        // when
        boolean result = BinarySearchTree.contains(n2, 3);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void should_return_true_if_contains_lower_value() {

        // given
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        // when
        boolean result = BinarySearchTree.contains(n2, 1);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void should_return_false_if_does_not_contain_greater_value() {

        // given
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        // when
        boolean result = BinarySearchTree.contains(n2, 4);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void should_return_false_if_does_not_contain_lower_value() {

        // given
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        // when
        boolean result = BinarySearchTree.contains(n2, 0);

        // then
        assertThat(result).isFalse();
    }
}
