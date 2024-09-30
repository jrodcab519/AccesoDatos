package Tema1Parte2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LecturaXML {
    public static void main(String[] args) {
        File xmlFile = new File("Persona.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Persona");

            for (int i = 0; i < nList.getLength(); i++) {
                Element personaElement = (Element) nList.item(i);
                System.out.println("Nombre: " + personaElement.getElementsByTagName("Nombre").item(0).getTextContent());
                System.out.println("Edad: " + personaElement.getElementsByTagName("Edad").item(0).getTextContent());
                System.out.println("Ciudad: " + personaElement.getElementsByTagName("Ciudad").item(0).getTextContent());
                System.out.println("------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
