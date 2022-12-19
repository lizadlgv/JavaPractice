package ru.dolgova.practice1.parser;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import ru.dolgova.practice1.dto.Flat;
import ru.dolgova.practice1.dto.Room;

import javax.xml.parsers.*;
import java.io.IOException;
import java.util.Objects;

public class DOMReader {
    private int indent = 0;
    final static int INDENT = 4;

    private final Flat flat = new Flat();

    private int height;
    private int width;
    private static int areaCalc = 0;
    private static String area;

    public Flat getFlat() {
        return flat;
    }

    public String getArea() {
        return area;
    }

    public int getAreaCalc() {
        return areaCalc;
    }

    private static final String[] TYPE_NAMES = {"ELEMENT_NODE", "ATTRIBUTE_NODE", "TEXT_NODE", "CDATA_SECTION_NODE", "ENTITY_REFERENCE_NODE", "ENTITY_NODE", "PROCESSING_INSTRUCTION_NODE", "COMMENT_NODE", "DOCUMENT_NODE", "DOCUMENT_TYPE_NODE", "DOCUMENT_FRAGMENT_NODE", "NOTATION_NODE"};

    public String getTypeName(short nodeType) {
        return TYPE_NAMES[nodeType - 1];
    }

    public void myPrint(Document document) {
        printDocInfo(document);
        printNodeInfo(document);
    }

    public void printDocInfo(Document document) {
        printString("Имя узла документа : " + document.getNodeName());
    }

    public void printElementInfo(Element element) {
        NamedNodeMap nnm = element.getAttributes();
        for (int i = 0; i < nnm.getLength(); i++) {
            Attr attr = (Attr) nnm.item(i);
            printString("Attribute name = " + attr.getName() + ", value = " + attr.getValue());
            if (attr.getName().equals("floor")) {
                flat.setFloor(Integer.valueOf(attr.getValue()));
            }
            if (attr.getName().equals("number")) {
                flat.setNumber(Integer.valueOf(attr.getValue()));
            }
            if (attr.getName().equals("height")) {
                height = Integer.parseInt(attr.getValue());
            }
            if (attr.getName().equals("width")) {
                width = Integer.parseInt(attr.getValue());
                flat.setRooms(new Room(height, width));
                areaCalc = areaCalc + height * width;
            }
        }
    }

    public void printTextInfo(Text text) {
        printString("Значение поля : " + text.getData());
        if (!Objects.equals(text.getData().trim(), "")) {
            area = text.getData();
        }
    }

    public void printNodeInfo(Node node) {
        indent += INDENT;
        printString("Node name = " + node.getNodeName() + ", node type = " + getTypeName(node.getNodeType()));
        if (node instanceof Element) {
            printElementInfo((Element) node);
        } else if (node instanceof Text) {
            printTextInfo((Text) node);
        }
        NodeList nl = node.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            printNodeInfo(nl.item(i));
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
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("src/main/resources/vf.xml");
            DOMReader obj = new DOMReader();
            obj.myPrint(document);
            if (area == null) {
                System.out.println("Площадь квартиры: " + areaCalc);
            } else {
                if (Integer.toString(areaCalc).equals(area)) {
                    System.out.println("Площадь квартиры: " + area);
                } else {
                    System.out.println("Действительная площади квартиры(" + areaCalc + ") не совпадает с площадью в xml-докумнте(" + area + ").");
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
