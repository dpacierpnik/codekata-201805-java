import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PathTest {

    @Test
    public void should_go_to_parent() {

        Path path = new Path("/a/b/c/d");

        path.cd("../x");

        assertThat(path.getPath()).isEqualTo("/a/b/c/x");
    }

    @Test
    public void should_go_to_parent_multiple_times() {

        Path path = new Path("/a/b/c/d");

        path.cd("../../../x");

        assertThat(path.getPath()).isEqualTo("/a/x");
    }

    @Test
    public void should_go_to_new_path() {

        Path path = new Path("/a/b/c/d");

        path.cd("/x");

        assertThat(path.getPath()).isEqualTo("/x");
    }
}
