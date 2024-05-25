//package laboratorio05;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

public class DOM {
    public static void main(String[] args) {
        try {
            // Inicializar el analizador DOM
            DOMParser parser = new DOMParser();

            // Analizar el archivo XML
            parser.parse("Ej01.xml");
            
            // Obtenga el documento analizado
            Document doc = parser.getDocument();
            
            // Procesar el documento según sea necesario
            Element rootElement = doc.getDocumentElement();
            System.out.println("Elemento raiz: " + rootElement.getNodeName());
            
            // Ejemplo de iteración a través de elementos
            NodeList secciones = rootElement.getElementsByTagName("seccion");
            for (int i = 0; i < secciones.getLength(); i++) {
                Node seccion = secciones.item(i);
                if (seccion.getNodeType() == Node.ELEMENT_NODE) {
                    Element seccionElement = (Element) seccion;
                    String tituloSeccion = seccionElement.getElementsByTagName("tit-seccion").item(0).getTextContent();
                    System.out.println("Seccion: " + tituloSeccion);
                    NodeList apartados = seccionElement.getElementsByTagName("apartado"); //.item(0).getTextContent();
                    for (int j = 0; j < apartados.getLength(); j++) {
                        Node apartado = apartados.item(j);
                        if (apartado.getNodeType() == Node.ELEMENT_NODE) {
                            Element apartadoElement = (Element) apartado;
                            NodeList organismoNodes = apartadoElement.getElementsByTagName("organismo");
                            // Siempre debería haber al menos un elemento "organismo" por "apartado"
                            if (organismoNodes.getLength() > 0) {
                                String organismo = organismoNodes.item(0).getTextContent();
                                System.out.println("  Organismo: " + organismo);
                            }
                        }
                    }
                }
            }
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
