package Tema1Parte2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class LecturaSAX {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean nombre = false;
                boolean edad = false;
                boolean ciudad = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("Nombre")) {
                        nombre = true;
                    } else if (qName.equalsIgnoreCase("Edad")) {
                        edad = true;
                    } else if (qName.equalsIgnoreCase("Ciudad")) {
                        ciudad = true;
                    }
                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (nombre) {
                        System.out.println("Nombre: " + new String(ch, start, length));
                        nombre = false;
                    } else if (edad) {
                        System.out.println("Edad: " + new String(ch, start, length));
                        edad = false;
                    } else if (ciudad) {
                        System.out.println("Ciudad: " + new String(ch, start, length));
                        ciudad = false;
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                }
            };

            saxParser.parse("Persona.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}