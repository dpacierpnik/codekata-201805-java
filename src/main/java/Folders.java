import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.LinkedList;

/**
 Implement a function folderNames, which accepts a string containing an XML file that specifies folder structure
 and returns all folder names that start with startingLetter. The XML format is given in the example below.

 For example, for the letter 'u' and an XML file:
 <code>
     <?xml version="1.0" encoding="UTF-8"?>
     <folder name="c">
     <folder name="program files">
     <folder name="uninstall information" />
     </folder>
     <folder name="users" />
     </folder>
 </code>

 the function should return a collection with items "uninstall information" and "users" (in any order).
 */
public class Folders {

    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {

        Collection<String> names = new LinkedList<>();

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();

        try (ByteArrayInputStream xmlIS = new ByteArrayInputStream(xml.getBytes("UTF-8"))) {

            parser.parse(xmlIS, new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

                    if (qName.equalsIgnoreCase("folder")) {
                        String folderName = attributes.getValue("name");
                        if (folderName.length() > 0 && folderName.charAt(0) == startingLetter) {
                            names.add(folderName);
                        }
                    }
                }
            });
        }

        return names;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for (String name : names)
            System.out.println(name);
    }
}