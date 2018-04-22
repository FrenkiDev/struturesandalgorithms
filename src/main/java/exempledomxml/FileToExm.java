package exempledomxml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class FileToExm {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        new FileToExm().runningParser();
    }

    public void runningParser() throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File("d:\\java_Project\\struturesandalgorithms\\source_doc\\patternPool.xml");

        DocumentBuilder document = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document documentDataPool = document.parse(xmlFile);

        Element elementScriptName = (Element)documentDataPool.getElementsByTagName("scriptPool").item(0);
        System.out.println(elementScriptName.getAttribute("nameScript"));

        Element newElementScript = documentDataPool.createElement("dataPool");
        newElementScript.setAttribute("nameScript", "DEP_5_1_Creat");
        elementScriptName.appendChild(newElementScript);
        
        Element newElementParam = documentDataPool.createElement("parametr");
        newElementParam.setAttribute("nameParametr", "clientId");
        newElementScript.appendChild(newElementParam);

        Element newElementValue = documentDataPool.createElement("value");
        newElementValue.setTextContent("value_clientID_1");
        newElementParam.appendChild(newElementValue);

        //Форматируем в текстовое представление
        transformToFile(documentDataPool);
    }

    private void transformToFile(Document documentDataPool) {
        try {
            Transformer transformers = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(documentDataPool);
            StreamResult sResukt = new StreamResult(new File("d:\\java_Project\\struturesandalgorithms\\source_doc\\resultPool.xml"));
            transformers.transform(domSource, sResukt);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
