package controller;

import model.Footballer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class SAXPar extends DefaultHandler {

    private static ArrayList <Footballer> footballers = new ArrayList<>();
    private static SAXPar saxPar;

    private SAXPar(){}

    public static SAXPar getSaxPar(){
        if(saxPar == null){
            saxPar = new SAXPar();
        }
        return saxPar;
    }

    public void setFile(File file) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        footballers.clear();
        XMLHandler handler = new XMLHandler();
        parser.parse(file, handler);
    }

    public ArrayList<Footballer> getFootballers(){
        return footballers;
    }

    private static class XMLHandler extends DefaultHandler {
        private String surName;
        private String firstName;
        private String middleName;
        private LocalDate birthDate;
        private String team;
        private String homeCity;
        private String commandStructure;
        private String position;
        private String lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("name")) {
                this.surName = attributes.getValue("surname");
                this.firstName = attributes.getValue("firstname");
                this.middleName = attributes.getValue("middlename");
            } else if (qName.equals("date")) {
                String date = attributes.getValue("date");
                this.birthDate = LocalDate.parse(date);
            } else {
                lastElementName = qName;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("team"))
                    this.team = information;
                if (lastElementName.equals("commandStructure"))
                    this.commandStructure = information;
                if (lastElementName.equals("position"))
                    this.position = information;
                if (lastElementName.equals("homeCity"))
                    this.homeCity = information;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (this.firstName != null && !this.firstName.isEmpty() &&
                this.surName != null && !this.surName.isEmpty() &&
                this.team != null && !this.team.isEmpty() &&
                this.position != null && !this.position.isEmpty() &&
                this.homeCity != null && !this.homeCity.isEmpty() &&
                this.commandStructure != null && !this.commandStructure.isEmpty() &&
                this.birthDate != null  &&
                this.middleName!= null && !this.middleName.isEmpty()) {
                footballers.add(new Footballer(
                        this.surName, this.firstName,
                        this.middleName, this.birthDate,
                        this.team, this.homeCity,
                        this.commandStructure, this.position
                ));
                this.surName = null;
                this.firstName = null;
                this.middleName = null;
                this.birthDate = null;
                this.commandStructure = null;
                this.homeCity = null;
                this.position = null;
                this.team = null;
            }
        }
    }
}
