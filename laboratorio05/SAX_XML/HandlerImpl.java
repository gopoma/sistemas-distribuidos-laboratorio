package SAX_XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandlerImpl extends DefaultHandler{

    boolean control = false;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("titulo")){
            System.out.println("\t");
            control = true;
        }
        else if (qName.equalsIgnoreCase("tit-seccion")) {
            System.out.print("SECCION: ");
            control = true;
        }
        else if (qName.equalsIgnoreCase("organismo")) {
            System.out.print("- ORGANISMO: ");
            control = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("titulo")){
            control = false;
        }
        else if (qName.equalsIgnoreCase("tit-seccion")) {
            control = false;
        }
        else if (qName.equalsIgnoreCase("organismo")) {
            control = false;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (control)
            System.out.println(" " + new String(ch, start, length));
    }

}
