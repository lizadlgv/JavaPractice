package ru.dolgova.practice1.parser;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.LocatorImpl;
import ru.dolgova.practice1.dto.Flat;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXReader extends DefaultHandler {

    private int indent = 0;
    final static int INDENT = 4;

    public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException {
    }

    public void endElement (String uri, String localName, String qName) throws SAXException {
    }

    public void warning (SAXParseException e) throws SAXException {
    }

    public void error (SAXParseException e) throws SAXException {
    }

    public void fatalError (SAXParseException e) throws SAXException {
    }
}
