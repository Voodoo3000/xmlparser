package xmlparser;

import appliances.Fridge;
import appliances.PC;
import appliances.Router;
import appliances.TV;
import electronics.ApplianceList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Voodoo3000 on 30.07.2017.
 */
public class ApplianceSTAXParser {
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
    private String element = "";

    public ApplianceList xmlSTAXParsing(String xmlDir) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            InputStream inputFile = new FileInputStream(xmlDir);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputFile);
            process(reader);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (XMLStreamException ex) {
            ex.printStackTrace();
        }
        return appliance;
    }

    private void process(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    element = reader.getLocalName();
                    if (this.element.equals(APPLIANCELIST)) {
                        appliance = new ApplianceList();
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    addAppliance(reader.getLocalName());
                    break;
                case XMLStreamConstants.CHARACTERS:
                    getField(element, reader);
                    break;
            }
        }
    }

    private void addAppliance(String name) {

        switch (name) {
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

    private void getField(String element, XMLStreamReader reader) {
        if (!reader.getText().trim().equals("")) {
            switch (element) {
                case MODELNAME:
                    this.modelName = reader.getText();
                    break;
                case POWER:
                    this.power = Double.parseDouble(reader.getText());
                    break;
                case ONOFF:
                    this.onOff = Boolean.parseBoolean(reader.getText());
                    break;
                case CAPACITY:
                    this.capacity = Integer.parseInt(reader.getText());
                    break;
                case CPUGHZ:
                    this.cpuGhz = Integer.parseInt(reader.getText());
                    break;
                case GPU:
                    this.gpu = reader.getText();
                    break;
                case LINKSPEED:
                    this.linkSpeed = Integer.parseInt(reader.getText());
                    break;
                case VLANFEATURE:
                    this.vlanFeature = reader.getText();
                    break;
                case DIAGSIZE:
                    this.diagSize = Integer.parseInt(reader.getText());
                    break;
                case DISPRESOL:
                    this.dispResol = reader.getText();
                    break;
            }
        }
    }

    public ApplianceList getAppliance() {
        return appliance;
    }
}
