package controller;

import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import model.Footballer;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**This is singleton
 * Class for writing List of
 * footballers to xml-file.
 */
public class DOMParser {

    private static DOMParser domParser;

    /**Method for access to the object.
     * @return single exemplar of this class.
     */
    public static DOMParser getDomParser(){
        if(domParser == null){
            domParser = new DOMParser();
        }
        return domParser;
    }

    private DOMParser() {}

    /**This method saves all information
     * @param footballers - list with footballers,
     * @param file - file in witch need to save.
     */
    public void createXML(List<Footballer> footballers, File file){
        System.out.println("here");
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("footballers");
            doc.appendChild(rootElement);


            for (Footballer footballer: footballers) {
                this.createRows(rootElement, doc, footballer);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    /**This method creates rows of xml-document in
     * file.
     * @param rootElement - main element
     * @param doc - document for saves,
     * @param realFootballer - array with footballers.
     */
    private void createRows(Element rootElement, Document doc, Footballer realFootballer){
        Element footballer = doc.createElement("footballer");
        rootElement.appendChild(footballer);

        Element name = doc.createElement("name");
        footballer.appendChild(name);

        Attr surName = doc.createAttribute("surname");
        surName.setValue(realFootballer.getSurName());
        name.setAttribute("surname", realFootballer.getSurName());

        Attr firstName = doc.createAttribute("firstname");
        surName.setValue(realFootballer.getFirstName());
        name.setAttribute("firstname", realFootballer.getFirstName());

        Attr middleName = doc.createAttribute("middlename");
        surName.setValue(realFootballer.getMiddleName());
        name.setAttribute("middlename", realFootballer.getMiddleName());

        Element date = doc.createElement("date");
        footballer.appendChild(date);

        Attr birthDate = doc.createAttribute("date");
        birthDate.setValue(realFootballer.getBirthDate().toString());
        date.setAttribute("date", realFootballer.getBirthDate().toString());

        Element team = doc.createElement("team");
        team.appendChild(doc.createTextNode(realFootballer.getTeam()));
        footballer.appendChild(team);

        Element homeCity = doc.createElement("homeCity");
        homeCity.appendChild(doc.createTextNode(realFootballer.getHomeCity()));
        footballer.appendChild(homeCity);

        Element commandStructure = doc.createElement("commandStructure");
        commandStructure.appendChild(doc.createTextNode(realFootballer.getCommandStructure()));
        footballer.appendChild(commandStructure);

        Element position = doc.createElement("position");
        position.appendChild(doc.createTextNode(realFootballer.getPosition()));
        footballer.appendChild(position);
    }
}