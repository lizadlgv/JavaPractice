package ru.dolgova.practice1.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Scanner;

public class SAXReader extends DefaultHandler {

    private int indent = 0;
    final static int INDENT = 4;

    private String area;
    private int areaCalc = 0;
    private int indexRoom = -1;

    public void startDocument() throws SAXException {
        printString("Начало документа");
    }

    public void endDocument() throws SAXException {
        printString("Конец документа");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        indent += INDENT;
        printString("Элемент " + qName + ":");
        if (qName.equals("flat")) {
            String floor = attributes.getValue("floor");
            String number = attributes.getValue("number");
            System.out.println(number + ", " + floor + " этаж");
        }
        if (qName.equals("room")) {
            indexRoom++;
            String height = attributes.getValue("height");
            String width = attributes.getValue("width");
            areaCalc = areaCalc + Integer.parseInt(height) * Integer.parseInt(width);
            System.out.println(indexRoom);
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        printString("Конец элемента " + qName + ".");
        if (qName.equals("area")) {
            if (area == null) {
                System.out.println("Площадь квартиры: " + areaCalc);
            } else {
                if (areaCalc == Integer.parseInt(area)) {
                    System.out.println("Площадь квартиры: " + area);
                } else {
                    System.out.println("Действительная площади квартиры(" + areaCalc + ") не совпадает с площадью в xml-докумнте(" + area + ").");
                }
            }
        }
        indent -= INDENT;
    }

    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Предупреждение :" + e.getPublicId());
    }

    public void error(SAXParseException e) throws SAXException {
        System.out.println("Ошибка :" + e.getPublicId());
    }

    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Фатальная ошибка :" + e.getPublicId());
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        indent += INDENT;
        String str = new String(ch, start, length);
        printString(str);
        if (!str.trim().isEmpty()) {
            area = String.valueOf(Integer.parseInt(str.trim()));
        }
        indent -= INDENT;
    }

    public void printString(String str) {
        String ind_s;
        if (indent > 0) {
            char[] ind = new char[indent];
            java.util.Arrays.fill(ind, ' ');
            ind_s = new String(ind, 0, indent);
        } else {
            ind_s = "";
        }
        System.out.println(ind_s + str);
    }

    public static void main(String[] args) {
        DefaultHandler handler = new SAXReader();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
        Scanner scanner = new Scanner(System.in);
        String fileName;
        try {
            System.out.print("Введите имя XML-файла: ");
            fileName = scanner.nextLine();
            parser = factory.newSAXParser();
            parser.parse("src/main/resources" + fileName + ".xml", handler);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
