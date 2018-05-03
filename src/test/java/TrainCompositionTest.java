import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrainCompositionTest {

    @Test
    public void should_detach_several_wagons() {

        TrainComposition tree = new TrainComposition();

        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        tree.attachWagonFromLeft(23);
        tree.attachWagonFromLeft(27);

        assertThat(tree.detachWagonFromRight()).isEqualTo(7);
        assertThat(tree.detachWagonFromRight()).isEqualTo(13);
        assertThat(tree.detachWagonFromLeft()).isEqualTo(27);
        assertThat(tree.detachWagonFromLeft()).isEqualTo(23);
    }
}
