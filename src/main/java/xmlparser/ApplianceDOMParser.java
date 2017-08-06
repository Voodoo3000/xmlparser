package xmlparser;

import appliances.Fridge;
import appliances.PC;
import appliances.Router;
import appliances.TV;
import electronics.ApplianceList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
    private Node appElement;

    public ApplianceList xmlDOMParsing(String xmlDir){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc =  builder.parse(xmlDir);
            appElement  = doc.getDocumentElement();
            if (appElement.getNodeName() == APPLIANCELIST) {
                appliance = new ApplianceList();
            }
            NodeList appList = appElement.getChildNodes();
            addAppliance(appList, appElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appliance;
    }

    private void addAppliance(NodeList appList, Node appElement) {
        for (int i = 0; i < appList.getLength(); i++) {
            if (appList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                NodeList fieldList = appElement.getChildNodes().item(i).getChildNodes();
                getField(fieldList);
                switch (appList.item(i).getNodeName()) {
                    case FRIDGE:
                        this.appliance.getAs().add(new Fridge(modelName, power, onOff, capacity));
                        break;
                    case PC:
                        this.appliance.getAs().add(new PC(modelName, power, onOff, cpuGhz, gpu));
                        break;
                    case ROUTER:
                        this.appliance.getAs().add(new Router(modelName, power, onOff, linkSpeed, vlanFeature));
                        break;
                    case TV:
                        this.appliance.getAs().add(new TV(modelName, power, onOff, diagSize, dispResol));
                        break;
                }
            }
        }
    }

    private void getField(NodeList fieldList) {
        for (int j = 0; j < fieldList.getLength(); j++) {
            if (fieldList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                Element specElement = (Element) fieldList.item(j);
                switch (specElement.getNodeName()) {
                    case MODELNAME:
                        this.modelName = specElement.getTextContent();
                        break;
                    case POWER:
                        this.power = Double.parseDouble(specElement.getTextContent());
                        break;
                    case ONOFF:
                        this.onOff = Boolean.parseBoolean(specElement.getTextContent());
                        break;
                    case CAPACITY:
                        this.capacity = Integer.parseInt(specElement.getTextContent());
                        break;
                    case CPUGHZ:
                        this.cpuGhz = Integer.parseInt(specElement.getTextContent());
                        break;
                    case GPU:
                        this.gpu = specElement.getTextContent();
                        break;
                    case LINKSPEED:
                        this.linkSpeed = Integer.parseInt(specElement.getTextContent());
                        break;
                    case VLANFEATURE:
                        this.vlanFeature = specElement.getTextContent();
                        break;
                    case DIAGSIZE:
                        this.diagSize = Integer.parseInt(specElement.getTextContent());
                        break;
                    case DISPRESOL:
                        this.dispResol = specElement.getTextContent();
                        break;
                }
            }
        }
    }

    public ApplianceList getAppliance() {
        return appliance;
    }
}
