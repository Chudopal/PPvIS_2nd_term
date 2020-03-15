package sample;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SAXPar extends DefaultHandler {

    private static ArrayList <Footballer> footballers = new ArrayList<>();

    SAXPar(){}

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File("resource/xml_file1.xml"), handler);

        for (Footballer  footballer : footballers)
            System.out.println(footballer.getSurName() + "\t" + footballer.getHomeCity());
    }

    private static class XMLHandler extends DefaultHandler {
        private String surName = "";
        private String firstName = "";
        private String middleName = "";
        private Date birthDate;
        private String team = "";
        private String homeCity = "";
        private String commandStructure = "";
        private String position = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Тут будет логика реакции на начало элемента
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Тут будет логика реакции на конец элемента
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Тут будет логика реакции на текст между элементами
        }

    }
}
