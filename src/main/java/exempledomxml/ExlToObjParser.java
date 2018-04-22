package exempledomxml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExlToObjParser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        new ExlToObjParser().runingParser();
    }

    public void runingParser() throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File("d:\\java_Project\\struturesandalgorithms\\source_doc\\file.xml");

        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document documents = docBuilder.parse(xmlFile);

        Element elementDoc = (Element) documents.getElementsByTagName("employers").item(0);
        String departament = elementDoc.getAttribute("departament");
        System.out.println(departament);

        NodeList employeeNodeList = elementDoc.getElementsByTagName("employee");

        List<Employee> employeesList = new ArrayList<>();

        //Изменить на лябда
        for (int i = 0; i < employeeNodeList.getLength(); i++) {
            if (employeeNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element employeeElemrt = (Element) employeeNodeList.item(i);
                Employee tmpEmploee = new Employee();

                tmpEmploee.setDepartament(departament);
                int tmp = Integer.valueOf(employeeElemrt.getAttribute("number"));
                tmpEmploee.setNamber(tmp);

                NodeList childList = employeeElemrt.getChildNodes();
                for (int j = 0; j < childList.getLength(); j++) {
                    if (childList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childList.item(j);
                        switchChildElement(tmpEmploee, childElement);
                    }
                }
            employeesList.add(tmpEmploee);
            }
        }
        employeesList.forEach(System.out :: println);
    }

    private void switchChildElement(Employee tmpEmploee, Element childElement) {
        switch (childElement.getNodeName()) {
            case "name": {
                tmpEmploee.setName(childElement.getTextContent());
            }
            break;
            case "age": {
                tmpEmploee.setAge(Integer.valueOf(childElement.getTextContent()));
            }
            break;
            case "salary": {
                tmpEmploee.getSalarys().setCurrency(childElement.getAttribute("currency"));
                tmpEmploee.getSalarys().setValue(Double.valueOf(childElement.getTextContent()));
            }
            break;
        }
    }

}

class Employee {
    String departament;
    int namber;
    String name;
    int age;
    Salary salarys;

    public Employee() {
        this.salarys = new Salary();
    }

    class Salary {
        double value;
        String currency;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }

    public Salary getSalarys() {
        return salarys;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public int getNamber() {
        return namber;
    }

    public void setNamber(int namber) {
        this.namber = namber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "departament='" + departament + '\'' +
                ", namber=" + namber +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salarys=" + salarys.getValue() + " " + salarys.getCurrency() +
                '}';
    }
}
