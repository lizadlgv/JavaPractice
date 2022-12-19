package ru.dolgova.practice1.parser;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import ru.dolgova.practice1.dto.Flat;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.IOException;
import java.util.Scanner;

public class DOMWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inFile, outFile;
        try {
            System.out.print("Введите имя входного XML-файла: ");
            inFile = scanner.nextLine();
            System.out.print("Введите имя выходного XML-файла: ");
            outFile = scanner.nextLine();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("src/main/resources/" + inFile + ".xml");
            Flat flat = parse(document);
            Document doc = builder.newDocument();
            DOMSource dom_source = new DOMSource(saveFile(doc, flat));
            StreamResult out_stream = new StreamResult("src/main/resources/" + outFile + ".xml");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(/* !!!! */);

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(dom_source, out_stream);
        } catch (ParserConfigurationException | TransformerException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static Flat parse(Document document) {
        Flat flat;
        int areaCalc;
        String area;

        DOMReader obj = new DOMReader();
        obj.myPrint(document);
        flat = obj.getFlat();
        area = obj.getArea();
        areaCalc = obj.getAreaCalc();
        if (area == null) {
            flat.setArea(areaCalc);
            System.out.println("Площадь квартиры: " + areaCalc);
        } else {
            if (Integer.toString(areaCalc).equals(area)) {
                flat.setArea(Integer.valueOf(area));
                System.out.println("Площадь квартиры: " + area);
            } else {
                flat.setArea(areaCalc);
                System.out.println("Действительная площади квартиры(" + areaCalc + ") не совпадает с площадью в xml-докумнте(" + area + ").");
            }
        }
        return flat;
    }

    private static Document saveFile(Document document, Flat flat) {
        String fileName = "flat";
        Element root = document.createElement(fileName);
        Element area = document.createElement("area");
        document.appendChild(root);
        for (int i = 0; i < flat.getRooms().size(); i++) {
            Element element = document.createElement("root");
            element.setAttribute("height", String.valueOf(flat.getRooms().get(i).getHeight()));
            element.setAttribute("width", String.valueOf(flat.getRooms().get(i).getWidth()));
            root.appendChild(element);
        }
        area.setTextContent(String.valueOf(flat.getArea()));
        root.appendChild(area);
        return document;
    }
}
