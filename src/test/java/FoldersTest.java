import org.junit.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class FoldersTest {

    @Test
    public void should_parse_xml() throws Exception {

        // given
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        // when
        Collection<String> names = Folders.folderNames(xml, 'u');

        // then
        assertThat(names).containsOnly("uninstall information", "users");
    }
}
