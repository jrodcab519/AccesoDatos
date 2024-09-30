package Tema1Parte2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreacionXML {
    private static final String NOMBREARCHIVO = "persona.dat";

    public static void main(String[] args) {
        List<Persona> personas = leerPersonas();
        crearXML(personas);
    }

    private static List<Persona> leerPersonas() {
        List<Persona> personas = new ArrayList<>();
        File file = new File(NOMBREARCHIVO);
        if (!file.exists()) {
            return personas;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBREARCHIVO))) {
            personas = (List<Persona>) ois.readObject();
        } catch (EOFException e) {
            System.out.println("Archivo  vacío.");
        } catch (FileNotFoundException e) {
            System.out.println("No existe archivo.");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return personas;
    }

    private static void crearXML(List<Persona> personas) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("Personas");
            doc.appendChild(rootElement);

            for (Persona persona : personas) {
                Element personaElement = doc.createElement("Persona");

                Element nombre = doc.createElement("Nombre");
                nombre.appendChild(doc.createTextNode(persona.getNombre()));
                personaElement.appendChild(nombre);

                Element edad = doc.createElement("Edad");
                edad.appendChild(doc.createTextNode(String.valueOf(persona.getEdad())));
                personaElement.appendChild(edad);

                Element ciudad = doc.createElement("Ciudad");
                ciudad.appendChild(doc.createTextNode(persona.getCiudad()));
                personaElement.appendChild(ciudad);

                rootElement.appendChild(personaElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("Persona.xml");
            transformer.transform(source, result);
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
