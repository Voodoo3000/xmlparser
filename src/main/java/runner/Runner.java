package runner;


import validator.XMLValidator;
import xmlparser.ApplianceDOMParser;
import xmlparser.ApplianceSAXParser;
import xmlparser.ApplianceSTAXParser;

/**
 * Created by VladislavYTsa on 21.07.2017.
 */
public class Runner {
    private static final String XML_DIR = "src/main/java/xmlAndXsd/appliance.xml";
    private static final String XSD_DIR = "src/main/java/xmlAndXsd/appschema.xsd";

    public static void main(String[] args) {

        XMLValidator xmlValidator = new XMLValidator();
        boolean validRes = xmlValidator.validation(XML_DIR, XSD_DIR);
        System.out.println("XSD validation result is: " + validRes);

        ApplianceSAXParser saxParser = new ApplianceSAXParser();
        saxParser.xmlSAXParsing(XML_DIR);
        System.out.println(saxParser.getApplianceList().toString());

        ApplianceSTAXParser staxParser = new ApplianceSTAXParser();
        staxParser.xmlSTAXParsing(XML_DIR);
        System.out.println(staxParser.getAppliance().toString());

        System.out.println("Equals SAX to STAX: " + saxParser.getApplianceList().equals(staxParser.getAppliance()));

        ApplianceDOMParser domParser = new ApplianceDOMParser();
        domParser.xmlDOMParsing(XML_DIR);
        System.out.println(domParser.getAppliance().toString());

        System.out.println("Equals DOM to STAX: " + domParser.getAppliance().equals(staxParser.getAppliance()));

    }
}
