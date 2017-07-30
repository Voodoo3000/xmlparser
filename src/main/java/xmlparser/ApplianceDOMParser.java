package xmlparser;

import electronics.ApplianceList;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Voodoo3000 on 30.07.2017.
 */
public class ApplianceDOMParser {
    private static final String APPLIANCELIST = "appliancelist";
    private static final String FRIDGE = "fridge";
    private static final String PC = "pc";
    private static final String ROUTER = "router";
    private static final String TV = "tv";
    private static final String MODELNAME = "modelName";
    private static final String POWER = "power";
    private static final String ONOFF = "onOff";
    private static final String CAPACITY = "capacity";
    private static final String CPUGHZ = "cpuGhz";
    private static final String GPU = "gpu";
    private static final String LINKSPEED = "linkSpeed";
    private static final String VLANFEATURE = "vlanFeature";
    private static final String DIAGSIZE = "diagSize";
    private static final String DISPRESOL = "dispResol";

    private String modelName = "";
    private double power;
    private boolean onOff;
    private int capacity;
    private int cpuGhz;
    private String gpu = "";
    private int linkSpeed;
    private String vlanFeature = "";
    private int diagSize;
    private String dispResol = "";

    private ApplianceList appliance;
    private String element;

    public ApplianceList xmlDOMParsing(String xmlDir){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document =  builder.parse(xmlDir);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return appliance;
    }
}
