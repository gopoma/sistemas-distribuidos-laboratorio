package SAX_XML;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

public class Sax {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse("Ej01.xml", new HandlerImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
